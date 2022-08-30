package com.starchain.global;

import com.alibaba.fastjson2.JSONObject;
import com.starchain.network.WebSocketConnector;
import com.starchain.utils.Util;
import org.java_websocket.enums.ReadyState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketManager {
    private static class WebSocketManagerHolder{
        private static final WebSocketManager INSTANCE = new WebSocketManager();
    }
    public static WebSocketManager getInstance(){
        return WebSocketManagerHolder.INSTANCE;
    }


    private WebSocketManager(){}
    private WebSocketConnector webSocketConnector;
    private String sessionCode;

    public void initial(String url){
        this.sessionCode = Util.createRandomMixture();
        this.webSocketConnector = new WebSocketConnector(url + "/" + this.sessionCode);
        double v = this.tryConnect();
        UpdateManager.getInstance().tryUpdate(v);
    }

    private double tryConnect(){
        ReadyState state = this.webSocketConnector.getReadyState();
        try {
            if(state.equals(ReadyState.NOT_YET_CONNECTED)){ // 还没连接过
                if(this.webSocketConnector.connectBlocking()){
                    JSONObject content = new JSONObject(Map.of("type", "version"));
                    JSONObject version_information = this.send_data("server:information", content, false);
                    if(version_information != null){
                        return version_information.getDouble("version");
                    }
                    return 0;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int tryReconnect(){
        try {
            if(this.webSocketConnector.reconnectBlocking()){
                ApplicationInformation applicationInformation = ApplicationInformation.getInstance();
                if(applicationInformation.getAccount() != null){
                    this.login(applicationInformation.getAccount(),
                            applicationInformation.getPassword());
                }
                return 1;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     * 向后端发送消息
     * @param destination 目标服务端
     * @param json_data 数据
     * @param asynchrony 是否开启异步（不等待数据返回）
     * @return 返回的信息
     */
    public JSONObject send_data(String destination, JSONObject json_data, boolean asynchrony){

        JSONObject post_Data_Body = new JSONObject();
        post_Data_Body.put("session_code", this.sessionCode);

        String event_code = null;
        if(!asynchrony) {
            event_code = Util.createRandomMixture();
            post_Data_Body.put("event_code", event_code);
        }

        post_Data_Body.put("destination", destination);
        post_Data_Body.put("content", json_data);

        ReadyState state = this.webSocketConnector.getReadyState();
        if(state.equals(ReadyState.CLOSED) || state.equals(ReadyState.CLOSING)){
            if(this.tryReconnect() == 0) return null;
        }

        this.webSocketConnector.send(post_Data_Body.toJSONString());

        if(!asynchrony){
            int i = 0;
            while (i < 1000){ // 超过1秒没有收到回信则默认连接超时，放弃获取回信
                try {
                    ConcurrentHashMap<String, JSONObject> eventPool = this.webSocketConnector.getEventPool();
                    if(eventPool.containsKey(event_code)){
                        // 当检测到事件池中出现回信，则退出等待进程
                        JSONObject json_result = eventPool.get(event_code);
                        eventPool.remove(event_code);
                        return json_result;
                    }
                    Thread.sleep(25);
                    i += 25;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 验证账号密码密码
     * @param account 账号
     * @param password 密码
     * @return 验证结果
     */
    public JSONObject login(String account, String password) {
        JSONObject json_post = new JSONObject();
        json_post.put("account", account);
        json_post.put("password", password);
        return this.send_data("server:login", json_post, false);
    }

}

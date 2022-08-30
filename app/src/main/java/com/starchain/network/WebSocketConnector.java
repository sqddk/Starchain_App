package com.starchain.network;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.starchain.global.MessageReceiver;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketConnector extends WebSocketClient {

    private final MessageReceiver messageReceiver;
    private final ConcurrentHashMap<String, JSONObject> eventPool;

    public WebSocketConnector(String url) {
        super(URI.create(url));
        this.messageReceiver = MessageReceiver.getInstance();
        this.eventPool = new ConcurrentHashMap<>();
    }

    @Override
    public void onOpen(ServerHandshake handshakeData) {
        System.out.println("已成功和服务端建立websocket连接！");
    }

    @Override
    public void onMessage(String message) {
        JSONObject jsonObject = JSON.parseObject(message);
        if(jsonObject.getString("order") == null){
            String eventCode = jsonObject.getString("event_code");
            JSONObject jsonContent = jsonObject.getJSONObject("content");
            this.eventPool.put(eventCode, jsonContent);
        }else{
            this.messageReceiver.handleMessage(jsonObject);
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }

    @Override
    public void onError(Exception ex) {
        throw new RuntimeException(ex);
    }

    public ConcurrentHashMap<String, JSONObject> getEventPool(){
        return this.eventPool;
    }
}

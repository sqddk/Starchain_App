package com.starchain.global;

import com.alibaba.fastjson2.JSONObject;

public class MessageReceiver {
    private static class MessageReceiverHolder{
        private static final MessageReceiver INSTANCE = new MessageReceiver();
    }
    public static MessageReceiver getInstance(){
        return MessageReceiverHolder.INSTANCE;
    }


    private MessageReceiver(){}
    private ResourceStorageCenter resourceStorageCenter;

    public void initial(){
        this.resourceStorageCenter = ResourceStorageCenter.getInstance();
    }

    /**
     * 处理来自服务端的主动推送信息
     * @param jsonObject 主动推送的json信息
     */
    public void handleMessage(JSONObject jsonObject){

    }

}

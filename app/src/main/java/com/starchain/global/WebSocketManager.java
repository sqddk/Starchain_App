package com.starchain.global;

import com.starchain.network.WebSocketConnector;

public class WebSocketManager {
    private static class WebSocketManagerHolder{
        private static final WebSocketManager INSTANCE = new WebSocketManager();
    }
    public static WebSocketManager getInstance(){
        return WebSocketManagerHolder.INSTANCE;
    }
    public static void init(){
        getInstance();
    }


    private WebSocketManager(){}
    private static final String URL = "";
    private final WebSocketConnector webSocketClient = new WebSocketConnector(URL);


}

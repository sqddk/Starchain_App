package com.starchain.network;

public class HttpsClient {
    private static class HttpsClientHolder{
        private static final HttpsClient INSTANCE = new HttpsClient();
    }
    public static HttpsClient getInstance(){
        return HttpsClientHolder.INSTANCE;
    }

    private HttpsClient(){}
    public void initial(){}

    /**
     * 发送https请求
     * @return responseBody
     */
    public String sendHttpsRequest(){
        return null;
    }

}

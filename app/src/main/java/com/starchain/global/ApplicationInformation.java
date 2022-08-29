package com.starchain.global;

public class ApplicationInformation {
    private static class ApplicationInformationHolder{
        private static final ApplicationInformation INSTANCE = new ApplicationInformation();
    }
    public static ApplicationInformation getInstance(){
        return ApplicationInformationHolder.INSTANCE;
    }
    public static void init(){
        getInstance();
    }


    private ApplicationInformation(){}
    private String account; // 用户账号

    /**
     * 获取本机用户账号
     * @return 账号
     */
    public String getAccount(){
        return this.account;
    }

    /**
     * 设置本机用户账号
     * @param account 账号
     */
    public void setAccount(String account){
        this.account = account;
    }

}

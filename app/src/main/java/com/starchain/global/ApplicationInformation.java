package com.starchain.global;

public class ApplicationInformation {
    private static class ApplicationInformationHolder{
        private static final ApplicationInformation INSTANCE = new ApplicationInformation();
    }
    public static ApplicationInformation getInstance(){
        return ApplicationInformationHolder.INSTANCE;
    }


    private ApplicationInformation(){}
    private String account; // 用户账号
    private String password; // 用户密码

    public void initial(){}

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

    /**
     * 获取本机用户密码
     * @return 密码
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * 设置本机密码
     * @param password 密码
     */
    public void setPassword(String password){
        this.password = password;
    }

}

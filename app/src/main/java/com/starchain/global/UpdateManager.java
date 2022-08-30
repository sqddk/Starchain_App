package com.starchain.global;

public class UpdateManager {
    private static class UpdateManagerHolder{
        private static final UpdateManager INSTANCE = new UpdateManager();
    }
    private UpdateManager(){}
    public static UpdateManager getInstance(){
        return UpdateManagerHolder.INSTANCE;
    }

    /**
     * 根据最新版本号和安装包下载地址进行升级
     * @param concurrentVersion 最新版本号
     */
    public void tryUpdate(double concurrentVersion) {

    }
}

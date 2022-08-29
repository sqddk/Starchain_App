package com.starchain.global;

public class ThemeManager {
    private static class ThemeManagerHolder{
        private static final ThemeManager INSTANCE = new ThemeManager();
    }
    public static ThemeManager getInstance(){
        return ThemeManagerHolder.INSTANCE;
    }
    public static void init(){
        getInstance();
    }


    private ThemeManager(){}
    private final ResourceStorageCenter resourceStorageCenter = ResourceStorageCenter.getInstance();

}

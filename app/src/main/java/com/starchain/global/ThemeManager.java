package com.starchain.global;

import android.content.res.Resources;
import android.graphics.Color;
import com.starchain.R;

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
    private int themeColor = Resources.getSystem ().getColor(R.color.theme_color);

    /**
     * 获取主题色
     * @return 主题色int值
     */
    public int getThemeColor(){
        return this.themeColor;
    }

}

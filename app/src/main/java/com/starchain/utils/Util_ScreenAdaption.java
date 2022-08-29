package com.starchain.utils;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Util_ScreenAdaption {

    /**
     * 设置状态栏隐藏
     * @param this_page 当前页面的对象
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void set_no_status(AppCompatActivity this_page){
        Window window = this_page.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        WindowManager.LayoutParams lp = this_page.getWindow().getAttributes();
        lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        window.setAttributes(lp);

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 设置webview和注册页的标题居中
     * @param textview TextView
     * @param this_page 当前页面对象
     */
    public static void set_title_center(TextView textview, AppCompatActivity this_page){
        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) textview.getLayoutParams();
        DisplayMetrics dm = this_page.getResources().getDisplayMetrics();
        int window_width = (int) (dm.widthPixels / dm.density);
        linearParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, window_width - 58, dm);
        textview.setLayoutParams(linearParams);
    }

    /**
     * 设置占据主要位置的scroll的高度，采用dp
     * @param scrollview ScrollView
     * @param this_page 当前页面对象
     * @param decrease_number_dp 需要隐藏的高度
     */
    public static void set_main_box_position_dp(View scrollview, AppCompatActivity this_page, int decrease_number_dp){
        DisplayMetrics dm = this_page.getResources().getDisplayMetrics();
        int window_height = (int) (dm.heightPixels / dm.density);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) scrollview.getLayoutParams();
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, window_height - decrease_number_dp, dm);
        scrollview.setLayoutParams(params);
    }

    /**
     * 把dp转换为px
     * @param context 页面对象
     * @param dpValue dp的值
     * @return px的值
     */
    public static int dip2px(Context context, float dpValue) {
        // 获取当前手机的像素密度（1个dp对应几个px）
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f); // 四舍五入取整
    }

}

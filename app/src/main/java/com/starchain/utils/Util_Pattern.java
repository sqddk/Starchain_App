package com.starchain.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.style.TitleBarStyle;
import com.starchain.R;
import com.starchain.activity.BaseActivity;
import com.starchain.global.ApplicationInformation;
import com.starchain.global.ThemeManager;
import com.yalantis.ucrop.UCrop;

public class Util_Pattern {

    /**
     * 返回软件使用协议的链接文字
     * @param this_page 当前页面的对象
     * @return 使用协议的链接文字 (SpannableString)
     */
    public static SpannableString get_agreement_Span(BaseActivity this_page) {
        SpannableString spannableString = new SpannableString("同意该软件的使用条款和隐私政策");
        spannableString.setSpan(new UnderlineSpan(), 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 11, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Util.createWebScreen(this_page.getString(R.string.span_service));
            }
        }, 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Util.createWebScreen(this_page.getString(R.string.span_information));
            }
        }, 11, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(101, 153, 200)), 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(101, 153, 200)), 11, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

    /**
     * 设置图片选择器的样式
     * @return 图片选择器的样式
     */
    public static PictureSelectorStyle createPictureSelectorStyleConfig(){

        PictureSelectorStyle style = new PictureSelectorStyle();
        SelectMainStyle select_main_style = new SelectMainStyle();
        BottomNavBarStyle bottom_bar_style = new BottomNavBarStyle();
        TitleBarStyle title_bar_style = new TitleBarStyle();

        int themeColor = ThemeManager.getInstance().getThemeColor();

        select_main_style.setSelectTextColor(themeColor);
        select_main_style.setNavigationBarColor(themeColor);
        select_main_style.setStatusBarColor(themeColor);
        select_main_style.setSelectNormalTextColor(themeColor);
        select_main_style.setMainListBackgroundColor(Color.WHITE);
        select_main_style.setPreviewBackgroundColor(Color.WHITE);
        select_main_style.setAdapterTagTextColor(themeColor);
        select_main_style.setAdapterDurationTextColor(themeColor);

        bottom_bar_style.setBottomSelectNumTextColor(Color.WHITE);
        bottom_bar_style.setBottomNarBarBackgroundColor(Color.WHITE);
        bottom_bar_style.setBottomPreviewSelectTextColor(themeColor);
        bottom_bar_style.setBottomSelectNumResources(R.drawable.ps_num_oval_selected);

        title_bar_style.setTitleBackgroundColor(themeColor);

        style.setSelectMainStyle(select_main_style);
        style.setBottomBarStyle(bottom_bar_style);
        style.setTitleBarStyle(title_bar_style);

        return style;
    }

    /**
     * 设置图片裁剪器的样式
     * @return 图片裁剪器的样式
     */
    public static UCrop.Options createUCropStyleConfig(){
        UCrop.Options style_options = new UCrop.Options();
        int themeColor = ThemeManager.getInstance().getThemeColor();

        style_options.setStatusBarColor(themeColor);
        style_options.setLogoColor(themeColor);
        style_options.setToolbarColor(themeColor);
        style_options.setToolbarWidgetColor(Color.WHITE);
        style_options.setActiveControlsWidgetColor(themeColor);

        return style_options;
    }

}

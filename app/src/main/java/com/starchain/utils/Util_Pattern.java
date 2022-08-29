package com.starchain.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import com.starchain.activity.BaseActivity;

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

            }
        }, 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        }, 11, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(101, 153, 200)), 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(101, 153, 200)), 11, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

}

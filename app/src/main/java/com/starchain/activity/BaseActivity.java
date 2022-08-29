package com.starchain.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.starchain.utils.Util_ScreenAdaption;

public class BaseActivity extends AppCompatActivity {

    private EditText editText;
    protected int available_distance = 0;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util_ScreenAdaption.set_no_status(this);
    }

    /**
     * 捕获窗口点击事件
     * @param ev android.view.MotionEvent
     * @return boolean
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                if (this.editText != null) {
                    this.editText.clearFocus();
                    closeKeyboard(v);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    /**
     * 是否应该取消输入框的焦点
     * @param v android.view.View
     * @param event android.view.MotionEvent
     * @return 是否应该取消 (boolean)
     */
    public boolean isShouldHideInput(View v, MotionEvent event) {
        int[] leftTop = {0, 0};
        if (v instanceof EditText) {
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth() + available_distance;

            boolean is_located = event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom;
            this.editText = (EditText) v;

            return !is_located;
        }
        return false;
    }

    /**
     * 关闭软键盘
     * @param view android.view.View
     */
    public void closeKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}

package com.starchain.global;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.style.MIUIStyle;
import com.starchain.network.HttpsClient;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        this.initAllGlobalMembers();

        DialogX.init(this);
        DialogX.globalStyle = new MIUIStyle();
        DialogX.implIMPLMode= DialogX.IMPL_MODE.DIALOG_FRAGMENT;

        this.initBackgroundCallBack();
    }

    /**
     * 初始化全局操作的各类实例
     */
    private void initAllGlobalMembers(){
        ResourceStorageCenter.init();
        MessageReceiver.init();
        ThemeManager.init();
        ApplicationInformation.init();
        ConfigureManager.init();
        WebSocketManager.init();
        HttpsClient.init();
    }

    /**
     * 为application注册一个应用监听，监听前后台之间的切换
     */
    private void initBackgroundCallBack() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }

}

package com.starchain.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.*;
import com.kongzue.dialogx.dialogs.FullScreenDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.starchain.R;

public class Util {

    /**
     * 根据url创建一个网页
     * @param url 网址
     */
    public static void createWebScreen(String url){
        FullScreenDialog.show(new OnBindView<FullScreenDialog>(R.layout.activity_webview) {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onBind(FullScreenDialog dialog, View v) {
                WebView webView = v.findViewById(R.id.webview);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

                webView.setWebChromeClient(new WebChromeClient());
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(url);
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        view.loadUrl(request.getUrl().toString());
                        return true;
                    }
                });
            }
        });
    }

}

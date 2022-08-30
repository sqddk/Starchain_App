package com.starchain.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.*;
import com.kongzue.dialogx.dialogs.FullScreenDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.starchain.R;

import java.util.Random;

public class Util {

    /**
     * 根据url创建一个网页
     * @param url 网址
     */
    public static void createWebScreen(String url){
        FullScreenDialog.show(new OnBindView<>(R.layout.activity_webview) {
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

    /**
     * 获取十位数的字母数字混合的String
     * @return 混合字符串 (String)
     */
    public static String createRandomMixture(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 10; i++){
            Random random = new Random();
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if(charOrNum.equals("char")){
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                char val = (char)(choice + random.nextInt(26));
                sb.append(val);
            }else {
                int num = random.nextInt(9);
                sb.append(num);
            }
        }
        return sb.toString();
    }

}

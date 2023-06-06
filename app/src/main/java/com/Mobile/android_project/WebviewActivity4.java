package com.Mobile.android_project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WebviewActivity4 extends AppCompatActivity {
    private WebView webview_web4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web4_libarary);

        webview_web4= findViewById(R.id.webview_web4);
        webview_web4.setWebViewClient(new WebViewClient());
        Button back_btn_web3 = findViewById(R.id.back_btn_web4);


        back_btn_web3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebviewActivity4.this, WebsiteActivity.class);
                startActivity(intent);
            }
        });

        WebSettings webSettings =  webview_web4.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webview_web4.clearCache(true);
        webview_web4.loadUrl("https://lib.mjc.ac.kr/");

    }
}
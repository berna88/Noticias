package com.example.berna.noticias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_info;
    private WebView wv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv_content = (WebView) findViewById(R.id.wv_content);
        tv_info = (TextView) findViewById(R.id.tv_info);
        String title = getIntent().getStringExtra("title");
        String body = getIntent().getStringExtra("body");
        String image = getIntent().getStringExtra("image");
        String url = getIntent().getStringExtra("url");
        //tv_info.append(title+body+url);
        /*
        if (getIntent().getExtras()!= null){
            for (String key:getIntent().getExtras().keySet()){
                    String value = getIntent().getExtras().getString(key);
            }
        }
        */
        WebSettings webSettings = wv_content.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        wv_content.getSettings().setBuiltInZoomControls(true);
        wv_content.loadUrl(image+"=s0");



    }
}

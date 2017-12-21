package com.example.berna.noticias;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private TextView tv_info;
    private WebView wv_content;
    private LinearLayout linearLayout;
    private ImageView iv_get_notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_info = (TextView) findViewById(R.id.tv_info);
        iv_get_notification = (ImageView) findViewById(R.id.iv_get_notification);
        String title = getIntent().getStringExtra("title");
        String body = getIntent().getStringExtra("body");
        final String image = getIntent().getStringExtra("image");
        final String url = getIntent().getStringExtra("url");
        loadImage(image, url);
        //tv_info.append(title+body+url);
        /*
        if (getIntent().getExtras()!= null){
            for (String key:getIntent().getExtras().keySet()){
                    String value = getIntent().getExtras().getString(key);
            }
        }
        */
        tv_info.setText(title);

    }
    public void loadImage(String image, final String url){
        Picasso.with(this).load(image).placeholder(R.drawable.consistent)
                .error(R.drawable.consistent)
                .into(iv_get_notification, new Callback() {
                    @Override
                    public void onSuccess() {
                        iv_get_notification.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent view = new Intent();
                                view.setAction(Intent.ACTION_VIEW);
                                view.setData(Uri.parse(url));
                                startActivity(view);
                            }
                        });
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}

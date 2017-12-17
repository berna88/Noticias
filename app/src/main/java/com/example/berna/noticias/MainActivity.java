package com.example.berna.noticias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_info = (TextView) findViewById(R.id.tv_info);
        if (getIntent().getExtras()!= null){
            for (String key:getIntent().getExtras().keySet()){
                    String value = getIntent().getExtras().getString(key);
                    tv_info.append(key+" : "+ value);
            }
        }

    }
}

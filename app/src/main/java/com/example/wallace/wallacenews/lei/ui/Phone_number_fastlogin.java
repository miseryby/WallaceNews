package com.example.wallace.wallacenews.lei.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.wallace.wallacenews.R;

/*
 *Create by ${user} on ${date}
 */public class Phone_number_fastlogin extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_phone_fastlogin);

        ImageButton ib_login_fast=(ImageButton)findViewById(R.id.ib_login_phone_fastlogin);
        Button bt_login_fast=(Button)findViewById(R.id.bt_phone_fastlogin);

        //设置返回的监听
        ib_login_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt_login_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

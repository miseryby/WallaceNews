package com.example.wallace.wallacenews.lei.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wallace.wallacenews.R;

/*
 *Create by ${user} on ${date}
 */public class User_login extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin_style);

        ImageView iv_return=(ImageView)findViewById(R.id.iv_userlogin_return);
        TextView tv_register=(TextView)findViewById(R.id.tv_login_register);
        Button bt_login_confirm=(Button)findViewById(R.id.bt_login_confirm);
        TextView tv_phone_number=(TextView)findViewById(R.id.tv_login_numberLogin);
        TextView tv_forget_password=(TextView)findViewById(R.id.tv_login_forgetPW);

        //返回按钮监听
        iv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //注册按钮监听
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //确认按钮监听
        bt_login_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //手机快捷登录按钮监听
        tv_phone_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //忘记密码监听
        tv_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

package com.example.wallace.wallacenews.lei.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wallace.wallacenews.R;

/*
 *Create by ${user} on ${date}
 */public class Modify_pho_number extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_pho_number);

        Button button=(Button)findViewById(R.id.bt_login_confirm);
        ImageView imageView=(ImageView)findViewById(R.id.iv_modify_phone);
        EditText editText=(EditText)findViewById(R.id.et_login_number);

        //确认按钮监听
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Modify_pho_number.this,"@string/phone_set_success",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //返回按钮监听
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

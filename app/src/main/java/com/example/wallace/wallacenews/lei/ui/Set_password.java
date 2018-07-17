package com.example.wallace.wallacenews.lei.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wallace.wallacenews.R;

/*
 *Create by ${user} on ${date}
 */public class Set_password extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_password);

        //确认按钮监听
        Button bt_password_confirm=(Button)findViewById(R.id.bt_setpassword_confirm);
        bt_password_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password=((EditText)findViewById(R.id.et_setpassword_input)).getText().toString();
                String password_confirm=((EditText)findViewById(R.id.et_setpassword_confirm)).getText().toString();

                //确认密码有输入并且一致
                if(!"".equals(password)&&!"".equals(password_confirm))
                {
                    if(!password.equals(password_confirm))
                    {
                        Toast.makeText(Set_password.this,"@string/password_confirm_tip",Toast.LENGTH_SHORT).show();
                        ((EditText) findViewById(R.id.et_setpassword_input)).setText("");
                        ((EditText)findViewById(R.id.et_setpassword_confirm)).setText("");
                        (findViewById(R.id.et_setpassword_input)).requestFocus();
                    }
                    else
                    {
                        //将密码提交服务器，返回设置成功提示
                        Toast.makeText(Set_password.this,"@string/password_set_success",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

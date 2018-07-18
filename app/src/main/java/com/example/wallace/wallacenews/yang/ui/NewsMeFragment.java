package com.example.wallace.wallacenews.yang.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wallace.wallacenews.R;

public class NewsMeFragment extends android.support.v4.app.Fragment {
    private LinearLayout ll_login_register;
    private LinearLayout ll_phone_number;
    private LinearLayout ll_user_name;
    private LinearLayout ll_system_setting;
    private LinearLayout ll_cache_clear;
    private LinearLayout ll_exit_login;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_style, container, false);
       ll_login_register=(LinearLayout) v.findViewById(R.id.ll_user_login);
       ll_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), User_login.class);
                startActivity(mIntent);
            }
        });
        return v;
    }


}

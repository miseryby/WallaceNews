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
import com.example.wallace.wallacenews.lei.ui.Modify_pho_number;
import com.example.wallace.wallacenews.lei.ui.User_login;

public class NewsMeFragment extends android.support.v4.app.Fragment {
    private LinearLayout ll_login_register;
    private LinearLayout ll_phone_number;
    private LinearLayout ll_user_name;
    private LinearLayout ll_system_setting;
    private LinearLayout ll_cache_clear;
    private LinearLayout ll_exit_login;
    private LinearLayout ll_collect;
    private LinearLayout ll_history;
    private LinearLayout ll_night;
    private  ImageView ll_login_his;
    private  ImageView ll_login_col;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_style, container, false);

        ll_login_register=(LinearLayout) v.findViewById(R.id.ll_user_login);
//        ll_cache_clear=(LinearLayout)v.findViewById(R.id.ll_user_login_caheclear);
//        ll_exit_login=(LinearLayout)v.findViewById(R.id.ll_user_login_exitlogin);
//        ll_phone_number=(LinearLayout)v.findViewById(R.id.ll_user_login_phone);
//        ll_user_name=(LinearLayout)v.findViewById(R.id.ll_user_login_username);
//        ll_system_setting=(LinearLayout)v.findViewById(R.id.ll_user_login_setting);

       ll_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), User_login.class);
                startActivity(mIntent);
            }
        });
//        ll_login_his=(ImageView) v.findViewById(R.id.his);
        ll_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(mIntent);
            }
        });
//        ll_login_col=(ImageView) v.findViewById(R.id.col);
        ll_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), CollectActivity.class);
                startActivity(mIntent);
            }
        });

//       ll_cache_clear.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//
//           }
//       });
//
//       ll_exit_login.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//           }
//       });
//
//       ll_phone_number.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Intent mIntent = new Intent(getActivity(), Modify_pho_number.class);
//               startActivity(mIntent);
//           }
//       });
//
//       ll_user_name.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Intent mIntent = new Intent(getActivity(), User_login.class);
//               startActivity(mIntent);
//
//           }
//       });
//
//       ll_system_setting.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//           }
//       });
//
//       ll_collect.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//           }
//       });
//
//       ll_history.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//           }
//       });
//
//       ll_night.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//           }
//       });
        return v;
    }


}

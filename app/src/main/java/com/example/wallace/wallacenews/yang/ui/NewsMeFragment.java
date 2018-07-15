package com.example.wallace.wallacenews.yang.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wallace.wallacenews.R;

public class NewsMeFragment extends android.support.v4.app.Fragment {
    private  ImageView mImageViewLogin;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_me,container,false );
//        mImageViewLogin =(ImageView) v.findViewById( R.id.btn_lg );
//        mImageViewLogin.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        } );
        return v;
    }


}

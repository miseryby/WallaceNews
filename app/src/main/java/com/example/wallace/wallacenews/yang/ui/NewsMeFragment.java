package com.example.wallace.wallacenews.yang.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.peng.Global.GlobalVar;

import org.w3c.dom.Text;

import cn.bmob.v3.datatype.BmobFile;

public class NewsMeFragment extends android.support.v4.app.Fragment {
    private  ImageView mImageHis;
    private  ImageView mImageCol;
    ImageView MyIcon;
    TextView MyName;
    int i =0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.user_style,container,false );
        mImageHis =(ImageView) v.findViewById( R.id.his );
        MyIcon = (ImageView)v.findViewById(R.id.imageView4);
        MyName = (TextView) v.findViewById(R.id.myname);

//        if(GlobalVar.loginStatus==true) {
            //加载头像
//            String url = GlobalVar.nowUser.getIcon().getFileUrl();
//            Glide.with(NewsMeFragment.this)
//                    .load(url)
//                    .placeholder(R.drawable.place_image)//图片加载出来前，显示的图片
//                    .error(R.drawable.error_image)//图片加载失败后，显示的图片
//                    .into(MyIcon);
//              //加载用户名
//            MyName.setText(GlobalVar.nowUser.getUserName());
//        }

        mImageHis.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent intent =new Intent( getActivity(),HistoryActivity.class );
        startActivity( intent );
            }
        } );
        mImageCol =(ImageView) v.findViewById( R.id.col );
        mImageCol.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent( getActivity(),CollectActivity.class );
                startActivity( intent );
            }
        } );
        return v;
    }


}

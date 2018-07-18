package com.example.wallace.wallacenews.yang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wallace.wallacenews.R;

public class NewsMeFragment extends android.support.v4.app.Fragment {
    private  ImageView mImageHis;
    private  ImageView mImageCol;
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

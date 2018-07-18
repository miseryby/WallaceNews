package com.example.wallace.wallacenews.yang.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.peng.Util.NetworkNewsUtil;

import java.util.ArrayList;
import java.util.List;

public class PicFragment extends  android.support.v4.app.Fragment {
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            mDynamicAdapter = new PicAdapter( mStrings );


            mRecyclerView1.setAdapter( mDynamicAdapter );
//            mDynamicAdapter1 = new PicAdapter( mStrings2 );
//
//
//            mRecyclerView2.setAdapter( mDynamicAdapter1 );
        }
    };
    private PicAdapter mDynamicAdapter;
    private PicAdapter mDynamicAdapter1;
    private List<String> mStrings= new ArrayList<>(  );
    private List<String> mStrings2= new ArrayList<>(  );
    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.layout, container, false );
        mRecyclerView1 = (RecyclerView) v.findViewById( R.id.rcy_pic );
//        mRecyclerView2 = (RecyclerView) v.findViewById( R.id.rcy_pic2 );
        new Thread( new Runnable() {
            @Override
            public void run() {
                mStrings = NetworkNewsUtil.GetkejiPicture( handler );
                mStrings2 = NetworkNewsUtil.GetcaijingPicture(handler );
                handler.sendEmptyMessage( 0 );
            }
        }).start();
        mRecyclerView1.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        return v;
    }

    private class PicHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView1;
        String news ;

        public PicHolder(LayoutInflater inflater, ViewGroup parent) {
            super( inflater.inflate( R.layout.pic, parent, false ) );
            mImageView1 =(ImageView) itemView.findViewById( R.id.pic );

        }

        public void bind(String news) {
            this.news = news;
            Glide.with( PicFragment.this ).load( news ).into( mImageView1 );
        }
    }

    private class PicAdapter extends RecyclerView.Adapter<PicHolder> {
        List<String> mList = new ArrayList<>();
        private ImageView mImageView;
        public PicAdapter(List<String> pic) {
            mList = pic;
        }

        @Override
        public PicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );
            return new PicHolder( layoutInflater, parent );
        }

        @Override
        public void onBindViewHolder(PicHolder holder, int position) {
            String news = mList.get( position );
            holder.bind( news );
        }


        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}

package com.example.wallace.wallacenews.yang.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.peng.Util.NetworkNewsUtil;
import com.example.wallace.wallacenews.peng.beans.Data;
import com.example.wallace.wallacenews.yang.test.News;
import com.example.wallace.wallacenews.yang.test.NewsLab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsListFragment extends android.support.v4.app.Fragment{


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mRecyclerView.setAdapter(new NewsAdapter(NetworkNewsUtil.GetTopNewsFromNetwork()));
        }
    };
    List<Data> mDataList =new ArrayList<>(  );
    private RecyclerView mRecyclerView;
    private NewsAdapter mNewsAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_item,container,false );
        mRecyclerView =(RecyclerView) v.findViewById( R.id.rcy );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );

        handler.sendEmptyMessage( 0 );
        return  v;
    }

    private void updateUI() {

//       NewsLab newsLab =NewsLab.get( getActivity()  );
//       List<News> newsList =newsLab.getNews();

//        mDataList = NetworkNewsUtil.GetTopNewsFromNetwork();
//        mNewsAdapter =new NewsAdapter( mDataList );
//        mRecyclerView.setAdapter( mNewsAdapter );
    }

    private class NewsHolder extends RecyclerView.ViewHolder{
        private TextView mTextView1;
        private TextView mTextView2;
        private  Data news;
        public NewsHolder(LayoutInflater inflater,ViewGroup parent) {

            super( inflater.inflate( R.layout.list_item_news,parent,false ) );
            mTextView1 =(TextView) itemView.findViewById( R.id.news_title );
            mTextView2 =(TextView) itemView.findViewById( R.id.new_detail );
        }
        public void bind(Data news){
            this.news =news;
            mTextView1.setText( news.getTitle() );
            mTextView2.setText( news.getDate().toString() );
        }
    }
    private  class  NewsAdapter extends RecyclerView.Adapter<NewsHolder>{
        List<Data> mList =new ArrayList<>(  );
        public NewsAdapter(List<Data> news){
            mList = news;
        }
        @Override
        public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );

            return new NewsHolder( layoutInflater,parent );
        }

        @Override
        public void onBindViewHolder(NewsHolder holder, int position) {
            Data news =mList.get( position );
            holder.bind( news );
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        }
    }



package com.example.wallace.wallacenews.yang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.peng.beans.Data;
import com.example.wallace.wallacenews.yang.adapter.MyRecyclerViewAdapter;
import com.example.wallace.wallacenews.yang.util.NewsCache;
import com.example.wallace.wallacenews.yang.util.SerializeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Data> mHistoryList=new ArrayList<>(  );
    private NewsAdapter mNewsAdapter;
    private String title="newsC";
    private MyRecyclerViewAdapter mMyRecyclerViewAdapter;


    public CollectActivity() {
    }

    //    private NewsListFragment.NewsAdapter mNewsAdapter;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_collect );

//        mHistoryList =mMyApplication.getListHistory();
        mRecyclerView=(RecyclerView) findViewById( R.id.rcy3 );
        NewsCache mCache = new NewsCache( getApplicationContext() );
        try {
            mHistoryList =(ArrayList<Data>) SerializeUtils.serializeToObject(mCache.getReadPageIndexByURL("F"+title));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mRecyclerView.setLayoutManager( new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false ) );
        mMyRecyclerViewAdapter =new MyRecyclerViewAdapter( mHistoryList );
        mNewsAdapter =new NewsAdapter( mHistoryList );

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mNewsAdapter );
    }

    private class NewsHolder extends RecyclerView.ViewHolder {
        private TextView mTextView1;
        private TextView mTextView2;
        private ImageView mImageView;

        private Data news;

        public NewsHolder(LayoutInflater inflater, ViewGroup parent) {

            super( inflater.inflate( R.layout.list_item_news, parent, false ) );

            mTextView1 = (TextView) itemView.findViewById( R.id.news_title );
            mTextView2 = (TextView) itemView.findViewById( R.id.new_detail );
            mImageView = (ImageView) itemView.findViewById( R.id.imageView );
        }

        public void bind(final Data news) {
            this.news = news;
            mTextView1.setText( news.getTitle() );
            mTextView2.setText( news.getDate().toString() );
            final String url = news.getUrl();
            mTextView1.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(CollectActivity.this, news.getTitle(), Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(CollectActivity.this,WebNews.class);
                    intent.putExtra( "URL", url);

                    startActivity(intent);
                }
            } );
            String pic = news.getThumbnail_pic_s();
            Glide.with( CollectActivity.this ).load( pic ).into( mImageView );
        }
    }

    private class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
        List<Data> mList = new ArrayList<>();

        public NewsAdapter(List<Data> news) {
            mList = news;
        }

        @Override
        public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( CollectActivity.this );
            return new NewsHolder( layoutInflater, parent );

        }

        @Override
        public void onBindViewHolder(NewsHolder holder, final int position) {
            Data news = mList.get( position );
            holder.bind( news );

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

    }

}

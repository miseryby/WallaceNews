package com.example.wallace.wallacenews.yang.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.peng.Util.NetworkNewsUtil;
import com.example.wallace.wallacenews.peng.beans.Data;
import com.example.wallace.wallacenews.yang.adapter.MyFragmentPagerAdapter;
import com.example.wallace.wallacenews.yang.test.News;
import com.example.wallace.wallacenews.yang.test.NewsLab;
import com.example.wallace.wallacenews.yang.util.NewsCache;
import com.example.wallace.wallacenews.yang.util.SerializeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SuppressLint("ValidFragment")
public class NewsListFragment extends android.support.v4.app.Fragment {

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            mNewsAdapter = new NewsAdapter( mDataList );

            mRecyclerView.setAdapter( mNewsAdapter );
        }
    };
    private  String s = null;
    private int mNewsSort;
    private NewsCache cache;
    private String title ="news";
    @SuppressLint("ValidFragment")
    public NewsListFragment(int newsSort) {
        mNewsSort = newsSort;
    }

    List<Data> mDataList = new ArrayList<>();
    List<Data> mDataListH = new ArrayList<>();
    private List<android.support.v4.app.Fragment> listfragment = new ArrayList<>(); //创建一个List<Fragment>

    private RecyclerView mRecyclerView;
    private NewsAdapter mNewsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    //    public static NewsListFragment newInstance(String sort){
//        NewsListFragment newsListFragment =new NewsListFragment();
//        return newsListFragment;
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_sort, container, false );
        new Thread( new Runnable() {
            @Override
            public void run() {
                switch (mNewsSort){
                    case 0:mDataList = NetworkNewsUtil.GetTopNewsFromNetwork( handler );
                    case 1:mDataList = NetworkNewsUtil.GetShehuiNewsFromNetwork( handler );
                    case 2:mDataList = NetworkNewsUtil.GetGuoneiNewsFromNetwork( handler );
                    case 3:mDataList = NetworkNewsUtil.GetGuojiNewsFromNetwork( handler );
                    case 4:mDataList = NetworkNewsUtil.GetTopNewsFromNetwork( handler );
                    case 5:mDataList = NetworkNewsUtil.GetTopNewsFromNetwork( handler );
                    case 6:mDataList = NetworkNewsUtil.GetTopNewsFromNetwork( handler );
                }

                int i = mDataList.size();
                handler.sendEmptyMessage( 0 );
            }
        } ).start();

        mRecyclerView = (RecyclerView) v.findViewById( R.id.rcy );

        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );

//        updateUI();

        return v;
    }

    private void updateUI() {

//       NewsLab newsLab =NewsLab.get( getActivity()  );
//       List<News> newsList =new ArrayList<>(  );

        while (mDataList.size() == 0) {
            mDataList = NetworkNewsUtil.GetTopNewsFromNetwork( handler );
        }
        mNewsAdapter = new NewsAdapter( mDataList );
        mRecyclerView.setAdapter( mNewsAdapter );
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
//                    mDataListH.add( news );
//
//                    try {
//                        s = SerializeUtils.serialize(mDataList);
//                        if (cache.checkByKey("F"+title)) {
//                            cache.updateValue("F"+title, s);
//                        }
//                        else {
//                            cache.insert("F"+title, s);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//

                    Toast.makeText(getActivity(), news.getTitle(), Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(getActivity(),WebNews.class);
                    intent.putExtra( "URL", url);
//                    intent.putExtra( "news",news );
                    startActivity(intent);
                }
            } );

            String pic = news.getThumbnail_pic_s();
            Glide.with( NewsListFragment.this ).load( pic ).into( mImageView );
        }
    }

    private class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
        List<Data> mList = new ArrayList<>();

        public NewsAdapter(List<Data> news) {
            mList = news;
        }

        @Override
        public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );
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

    public static interface ItemClickListener {
        void onItemClick(View view);
        void onImageClick(View view);
    }

    public ItemClickListener mListener;

    public void setOnItemClickListener(ItemClickListener listener) {
        this.mListener = listener;
    }
    }




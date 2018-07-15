package com.example.wallace.wallacenews.yang.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.yang.test.News;
import com.example.wallace.wallacenews.yang.test.NewsLab;

import java.util.ArrayList;
import java.util.List;

public class DynamicListFragment extends  android.support.v4.app.Fragment {
    private RecyclerView mRecyclerView;
    private DynamicAdapter mDynamicAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_dynamic, container, false );
        mRecyclerView = (RecyclerView) v.findViewById( R.id.rcdy );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        updateUI();
        return v;
    }
    private void updateUI() {

        NewsLab newsLab =NewsLab.get( getActivity()  );
        List<News> newsList =newsLab.getNews();
        mDynamicAdapter =new DynamicAdapter( newsList );
        mRecyclerView.setAdapter( mDynamicAdapter );
    }
    private class DynamicHolder extends RecyclerView.ViewHolder {
        private TextView mTextView1;
        private TextView mTextView2;
        private News news;

        public DynamicHolder(LayoutInflater inflater, ViewGroup parent) {

            super( inflater.inflate( R.layout.dynamic_condition_fragment_item, parent, false ) );
            mTextView1 = (TextView) itemView.findViewById( R.id.dyname );
            mTextView2 = (TextView) itemView.findViewById( R.id.dyTime );
        }

        public void bind(News news) {
            this.news = news;
            mTextView1.setText( "hello" );
            mTextView2.setText( "颜表情" );
        }
    }

    private class DynamicAdapter extends RecyclerView.Adapter<DynamicHolder> {
        List<News> mList = new ArrayList<>();

        public DynamicAdapter(List<News> news) {
            mList = news;
        }

        @Override
        public DynamicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );
            return new DynamicHolder( layoutInflater, parent );
        }

        @Override
        public void onBindViewHolder(DynamicHolder holder, int position) {
            News news = mList.get( position );
            holder.bind( news );
        }


        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}

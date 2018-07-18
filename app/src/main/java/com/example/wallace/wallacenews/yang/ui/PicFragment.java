package com.example.wallace.wallacenews.yang.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.wallace.wallacenews.R;

import java.util.ArrayList;
import java.util.List;

public class PicFragment extends  android.support.v4.app.Fragment {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView( inflater, container, savedInstanceState );
    }

    private class DynamicHolder extends RecyclerView.ViewHolder {
        private TextView mTextView1;
        private TextView mTextView2;
        private String news;

        public DynamicHolder(LayoutInflater inflater, ViewGroup parent) {

            super( inflater.inflate( R.layout.layout, parent, false ) );

        }

        public void bind(String news) {
            this.news = news;

        }
    }

    private class DynamicAdapter extends RecyclerView.Adapter<DynamicHolder> {
        List<String> mList = new ArrayList<>();

        public DynamicAdapter(List<String> news) {
            mList = news;
        }

        @Override
        public DynamicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );
            return new DynamicHolder( layoutInflater, parent );
        }

        @Override
        public void onBindViewHolder(DynamicHolder holder, int position) {
            String news = mList.get( position );
            holder.bind( news );
        }


        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}

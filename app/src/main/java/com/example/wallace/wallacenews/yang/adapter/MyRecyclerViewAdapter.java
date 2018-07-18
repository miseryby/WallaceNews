package com.example.wallace.wallacenews.yang.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.peng.beans.Data;
import com.example.wallace.wallacenews.yang.util.NewsCache;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<Data> list =new ArrayList<>(  );

    public MyRecyclerViewAdapter(List<Data> list) {
        this.list = list;
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item_news, parent, false);
        MyRecyclerViewAdapter.ViewHolder viewHolder = new MyRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mText.setText(list.get(position).getTitle());
//        holder.mTextViewDate.setText(list.get( position ).getDate().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mText;
        TextView mTextViewDate;

        ViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.news_title);
//            mTextViewDate = (TextView) itemView.findViewById(R.id.new_detail);
            mText.setText( "1" );
        }


    }

}

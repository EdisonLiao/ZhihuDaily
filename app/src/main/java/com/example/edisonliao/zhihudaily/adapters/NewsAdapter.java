package com.example.edisonliao.zhihudaily.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edisonliao.zhihudaily.R;
import com.example.edisonliao.zhihudaily.entity.NewsItemData;

import java.util.List;

/**
 * Created by edisonliao on 2018/2/7.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    private List<NewsItemData> mList;
    private Context mContext;

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_layout,null);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        public NewsViewHolder(View itemView) {
            super(itemView);
        }
    }


}

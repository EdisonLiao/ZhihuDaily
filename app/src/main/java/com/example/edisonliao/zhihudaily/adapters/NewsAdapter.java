package com.example.edisonliao.zhihudaily.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edisonliao.zhihudaily.R;
import com.example.edisonliao.zhihudaily.entity.NewsItemData;
import com.example.edisonliao.zhihudaily.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edisonliao on 2018/2/7.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    private List<NewsItemData> mList;
    private Context mContext;

    public NewsAdapter(Context context){
        mContext = context;
        mList = new ArrayList<>();
    }

    public void updateList(List<NewsItemData> list){
        mList.clear();
        mList.addAll(list);
        notifyItemRangeChanged(0,list.size());
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_layout,
                parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsItemData newsData = mList.get(position);
        holder.textView.setText(newsData.getTxt());
        GlideUtil.getInstance().loadImgWithUrl(mContext,newsData.getImgUrl(),holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.news_iv)
        ImageView imageView;
        @BindView(R.id.news_title_tv)
        TextView textView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}

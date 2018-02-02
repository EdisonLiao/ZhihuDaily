package com.example.edisonliao.zhihudaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.edisonliao.zhihudaily.entity.LastNewsStories;
import com.example.edisonliao.zhihudaily.entity.LastNewsTopStories;
import com.example.edisonliao.zhihudaily.view.IMainActivityView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements IMainActivityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 最新消息的banner显示
     * @param lastNewsTopStories
     */
    @Override
    public void showLastNewsBannerImg(LastNewsTopStories lastNewsTopStories) {

    }

    /**
     * 最新消息的新闻列表
     * @param lastNewsStories
     */
    @Override
    public void showLastNews(LastNewsStories lastNewsStories) {

    }
}

package com.example.edisonliao.zhihudaily.view;

import com.example.edisonliao.zhihudaily.entity.LastNewsResponse;
import com.example.edisonliao.zhihudaily.entity.LastNewsStories;
import com.example.edisonliao.zhihudaily.entity.LastNewsTopStories;

/**
 * Created by edisonliao on 2018/2/2.
 * MainActivity的V层接口
 */

public interface IMainActivityView {

    void showLastNewsBannerImg(LastNewsTopStories lastNewsTopStories);

    void showLastNews(LastNewsStories lastNewsStories);






}

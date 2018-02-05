package com.example.edisonliao.zhihudaily.retrofits;

import com.example.edisonliao.zhihudaily.entity.LastNewsResponse;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by edisonliao on 2018/2/2.
 * 最新消息
 */

public interface ApiService {

    String BASE_URL = "https://news-at.zhihu.com/";

    @GET("api/4/news/latest")
    Flowable<LastNewsResponse> getLastNewsService();

}

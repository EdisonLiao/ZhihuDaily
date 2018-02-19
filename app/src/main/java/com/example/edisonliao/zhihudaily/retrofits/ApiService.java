package com.example.edisonliao.zhihudaily.retrofits;

import com.example.edisonliao.zhihudaily.entity.LastNewsResponse;
import com.example.edisonliao.zhihudaily.entity.NewsDetailResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by edisonliao on 2018/2/2.
 * 最新消息
 */

public interface ApiService {

    String BASE_URL = "https://news-at.zhihu.com/";

    @GET("api/4/news/latest")
    Observable<LastNewsResponse> getLastNewsService();

    @GET("api/4/news/{id}")
    Observable<NewsDetailResponse> getNewsDetailService(@Path("id")int id);

}

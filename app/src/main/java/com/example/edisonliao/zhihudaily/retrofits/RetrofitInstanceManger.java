package com.example.edisonliao.zhihudaily.retrofits;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by edisonliao on 2018/2/2.
 */

public class RetrofitInstanceManger {
    private static Retrofit mRetrofit;

    public static Retrofit getInstance(){
        synchronized (RetrofitInstanceManger.class) {
            if (mRetrofit == null) {
                init();
            }
        }
        return mRetrofit;
    }

    private static void init(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }




}

package com.example.edisonliao.zhihudaily.utils;

/**
 * Created by edisonliao on 2018/2/7.
 */

public class GlideUtil {

    private static GlideUtil mInstance;

    public static GlideUtil getInstance(){
        if (mInstance == null){
            mInstance = new GlideUtil();
        }
        return mInstance;
    }





}

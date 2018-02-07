package com.example.edisonliao.zhihudaily.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

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

    public void loadImgWithUrl(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .into(imageView);
    }





}

package com.example.edisonliao.zhihudaily.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by EdisonLiao on 2018/2/5.
 */

public class GlideImageLoader extends ImageLoader{

    private static GlideImageLoader mInstance;

    public static GlideImageLoader getInstance(){
        if (mInstance == null){
            mInstance = new GlideImageLoader();
        }
        return mInstance;
    }

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load((String)path).into(imageView);
    }


}

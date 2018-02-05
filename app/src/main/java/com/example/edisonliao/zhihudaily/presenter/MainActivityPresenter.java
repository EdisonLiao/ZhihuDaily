package com.example.edisonliao.zhihudaily.presenter;

import android.util.Log;

import com.example.edisonliao.zhihudaily.entity.LastNewsResponse;
import com.example.edisonliao.zhihudaily.retrofits.ApiCallBack;
import com.example.edisonliao.zhihudaily.view.IMainActivityView;

/**
 * Created by edisonliao on 2018/2/2.
 */

public class MainActivityPresenter extends BasePresenter<IMainActivityView,LastNewsResponse> {
    private static final String TAG = "MainActivityPresenter";
    private IMainActivityView mMainView;

    public MainActivityPresenter(IMainActivityView mMainView){
        this.mMainView = mMainView;
        attachView(mMainView);
    }

    public void loadLastNews(){
        addSubscription(mApiService.getLastNewsService(), new ApiCallBack<LastNewsResponse>() {
            @Override
            public void onFinish() {
                Log.e(TAG,"onFinish");
            }

            @Override
            public void onSuccess(LastNewsResponse model) {
                Log.e(TAG,"onSuccess");
                mMainView.showLastNewsBannerImg(model.getTopStories());
            }

            @Override
            public void onFailure(String msg) {
                Log.e(TAG,"onFailure");
            }
        });
    }
















}

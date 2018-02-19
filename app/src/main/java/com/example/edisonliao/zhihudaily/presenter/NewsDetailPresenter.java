package com.example.edisonliao.zhihudaily.presenter;

import com.example.edisonliao.zhihudaily.entity.NewsDetailResponse;
import com.example.edisonliao.zhihudaily.retrofits.ApiCallBack;
import com.example.edisonliao.zhihudaily.view.INewsDetailActivityView;

/**
 * Created by EdisonLiao on 2018/2/19.
 */

public class NewsDetailPresenter extends BasePresenter<INewsDetailActivityView,NewsDetailResponse> {
    private static final String TAG = "NewsDetailPresenter";
    private INewsDetailActivityView mView;
    private int id;

    public NewsDetailPresenter(INewsDetailActivityView view,int id){
        mView = view;
        this.id = id;
        attachView(view);
    }

    public void loadNewsDetail(){
        addSubscription(mApiService.getNewsDetailService(id), new ApiCallBack<NewsDetailResponse>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onSuccess(NewsDetailResponse model) {
                mView.showNewsDetail(model);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }





}

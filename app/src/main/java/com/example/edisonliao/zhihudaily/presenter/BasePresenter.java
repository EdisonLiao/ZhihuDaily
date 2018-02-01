package com.example.edisonliao.zhihudaily.presenter;

/**
 * Created by EdisonLiao on 2018/2/1.
 * P层的基类
 */

public class BasePresenter<V> {

    private V mView;

    public void attachView(V mView){
        this.mView = mView;
    }

    public void detachView(){
        if (mView != null){
            this.mView = null;
        }
    }


}

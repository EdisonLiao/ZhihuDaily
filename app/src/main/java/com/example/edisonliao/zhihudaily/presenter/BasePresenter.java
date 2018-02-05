package com.example.edisonliao.zhihudaily.presenter;



import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by EdisonLiao on 2018/2/1.
 * P层的基类
 */

public class BasePresenter<V> {

    private V mView;
    private CompositeDisposable mComposite;
    public void attachView(V mView){
        this.mView = mView;
    }

    public void detachView(){
        if (mView != null){
            this.mView = null;
        }
    }

    public void onUnsubscribe(){
        if (mComposite != null){
            mComposite.clear();
        }
    }

    @SuppressWarnings("unchecked")
    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mComposite == null){
            mComposite = new CompositeDisposable();
        }
        mComposite.add();
    }


}

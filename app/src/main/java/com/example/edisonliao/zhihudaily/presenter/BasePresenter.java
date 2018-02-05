package com.example.edisonliao.zhihudaily.presenter;




import com.example.edisonliao.zhihudaily.entity.LastNewsResponse;
import com.example.edisonliao.zhihudaily.retrofits.ApiService;
import com.example.edisonliao.zhihudaily.retrofits.RetrofitInstanceManger;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by EdisonLiao on 2018/2/1.
 * P层的基类
 */

public class BasePresenter<V,M> {
    private static final String TAG = "BasePresenter";
    private V mView;
    private CompositeDisposable mComposite;
    protected ApiService mApiService;
    public void attachView(V mView){
        this.mView = mView;
        mApiService = RetrofitInstanceManger.getInstance().create(ApiService.class);
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

    public void addSubscription(Observable<M> observable, DisposableObserver<M> subscriber) {
        if (mComposite == null){
            mComposite = new CompositeDisposable();
        }
        mComposite.add(
                observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)

        );
    }
}

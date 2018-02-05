package com.example.edisonliao.zhihudaily.retrofits;


import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * Created by EdisonLiao on 2018/2/2.
 */

public abstract class ApiCallBack<M> extends DisposableObserver<M> {
    private static final String TAG = "ApiCallBack";
    public abstract void onFinish();
    public abstract void onSuccess(M model);
    public abstract void onFailure(String msg);



    @Override
    public void onComplete() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.message();
            if (code == 504){
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
            onFailure(msg);
        }else {
            onFailure(e.getMessage());
        }

    }

    @Override
    public void onNext(M m) {
        onSuccess(m);
    }
}

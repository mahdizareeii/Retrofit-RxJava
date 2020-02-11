package com.sample.myapplication.retrofit;

import android.util.Log;

import com.sample.myapplication.retrofit.interfaces.OnCallBackListener;

import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RetrofitHelper<T> {

    public RetrofitHelper(Observable<T> observable, final OnCallBackListener<T> onCallBackListener) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(T t) {
                        onCallBackListener.onCallBack(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof UnknownHostException)
                            Log.i("retrofit 23323", "onError: ");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package com.sample.myapplication.retrofit.interfaces;


import com.sample.myapplication.models.singersModel.SingersModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("GetSingers.php")
    Observable<SingersModel> getSingers();

}

package com.sample.myapplication.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.myapplication.retrofit.interfaces.RetrofitApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String baseUrl = "https://your_url.com/";
    private static final String retrofitUrl = baseUrl + "api/";

    private static Retrofit retrofit;
    private static Gson gson = new GsonBuilder().setLenient().create();
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .client(getClient())
            .baseUrl(retrofitUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = retrofitBuilder.build();
        }
        return retrofit;
    }

    public static RetrofitApi getRetrofitApi = getRetrofit().create(RetrofitApi.class);

}

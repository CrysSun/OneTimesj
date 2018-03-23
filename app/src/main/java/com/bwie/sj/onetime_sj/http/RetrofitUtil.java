package com.bwie.sj.onetime_sj.http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitUtil工具类
 * Created by Administrator on 2018/03/22.
 */

public class RetrofitUtil {
    //单利模式
    private static RetrofitUtil retrofitUtil;

    public String url;
    private final Retrofit retrofit;

    public static RetrofitUtil getInstace(String url) {
        if (retrofitUtil == null) {
            retrofitUtil = new RetrofitUtil(url);
        }
        return retrofitUtil;
    }

    //初始化retrofit
    public RetrofitUtil(String url) {
        this.url = url;
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    //反射子类
    public <T> T getData(Class<T> clz) {
        T t = retrofit.create(clz);
        return t;
    }
}

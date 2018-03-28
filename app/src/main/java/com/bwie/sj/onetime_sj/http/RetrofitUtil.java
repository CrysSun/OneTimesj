package com.bwie.sj.onetime_sj.http;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
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
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    //拦截器
    class MyInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            RequestBody body = request.body();
            if (body instanceof FormBody) {
                //创建新的  请求
                FormBody.Builder newBuilder = new FormBody.Builder();
                for (int i = 0; i < ((FormBody) body).size(); i++) {
                    String key = ((FormBody) body).name(i);
                    String value = ((FormBody) body).value(i);
                    newBuilder.add(key, value);
                }
                //添加公共参数
                newBuilder.add("source", "android");
                newBuilder.add("appVersion", "101");
                FormBody formBody = newBuilder.build();
                Request request1 = request.newBuilder().post(formBody).build();
                Response response = chain.proceed(request1);
                return response;
            }
            return null;
        }
    }

    //反射子类
    public <T> T getData(Class<T> clz) {
        T t = retrofit.create(clz);
        return t;
    }
}

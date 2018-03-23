package com.bwie.sj.onetime_sj.http;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * ok请求的
 * Created by Administrator on 2018/03/22.
 */

public class OkhttpUtil {
    //单利模式
    private static OkhttpUtil okhttpUtil;
    private static MyHandler myHandler = new MyHandler();
    private static OkLoadListener okLoadListener;


    public static OkhttpUtil getInstance() {
        if (okhttpUtil == null) {
            okhttpUtil = new OkhttpUtil();
        }
        return okhttpUtil;
    }

    //ok  get请求
    public static void okGet(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = myHandler.obtainMessage();
                message.what = 1;
                message.obj = e.getMessage();
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = myHandler.obtainMessage();
                message.what = 0;
                message.obj = response.body().string();
                myHandler.sendMessage(message);
            }
        });
    }

    //post请求
    public void okPost(String url, Map<String, String> params) {
        //请求对象        添加拦截器
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();
        //body
        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            String value = params.get(key);
            builder.add(key, value);
        }
        FormBody body = builder.build();
        //封装url地址
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = myHandler.obtainMessage();
                message.what = 1;
                message.obj = e.getMessage();
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = myHandler.obtainMessage();
                message.what = 0;
                message.obj = response.body().string();
                myHandler.sendMessage(message);
            }
        });
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
                FormBody formBody = newBuilder.build();
                Request request1 = request.newBuilder().post(formBody).build();
                Response response = chain.proceed(request1);
                return response;
            }
            return null;
        }
    }
    //handler
    static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 0://成功
                    okLoadListener.okLoadSuccess((String) msg.obj);
                    break;
                case 1://失败
                    okLoadListener.okLoadSuccess((String) msg.obj);
                    break;
            }
        }
    }

    //定义外部访问的方法
    public void setOkLoadListener(OkLoadListener okLoadListener) {
        this.okLoadListener = okLoadListener;
    }

}

package com.bwie.sj.onetime_sj.http;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
                message.what=1;
                message.obj=e.getMessage();
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = myHandler.obtainMessage();
                message.what=0;
                message.obj=response.body().string();
                myHandler.sendMessage(message);
            }
        });
    }
    //handler
    static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
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
    public void setOkLoadListener(OkLoadListener okLoadListener){
        this.okLoadListener=okLoadListener;
    }

}

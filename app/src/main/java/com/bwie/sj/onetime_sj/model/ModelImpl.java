package com.bwie.sj.onetime_sj.model;

import android.util.Log;

import com.bwie.sj.onetime_sj.bean.CoHotBean;
import com.bwie.sj.onetime_sj.http.OkLoadListener;
import com.bwie.sj.onetime_sj.http.OkhttpUtil;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 获取数据
 * Created by Administrator on 2018/03/22.
 */

public class ModelImpl implements ICoHotModel {

    private OkhttpUtil instance;
    private static final String TAG = "ModelImpl";

    //获取广告轮播
    @Override
    public void getAdverSuccess(String url, final GetDataListener getDataListener) {
        instance = OkhttpUtil.getInstance();
        //get请求
        instance.okGet(url);
        instance.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                getDataListener.getSuccess(json);
            }

            @Override
            public void okLoadErroer(String error) {
                getDataListener.getError(error);

            }
        });

    }

    //获取视频
    @Override
    public void getVideoSuccess(int page,String url, final GetVideoListener getVideoData) {
        RetrofitUtils instace = RetrofitUtils.getInstace(url);
        instace.getData(RetrofitService.class).getVideoList(page).enqueue(new Callback<CoHotBean>() {
            @Override
            public void onResponse(Call<CoHotBean> call, Response<CoHotBean> response) {
                Log.d(TAG, "onResponse: ++++++++++++" + response.body().getMsg());
                getVideoData.getVideoSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<CoHotBean> call, Throwable t) {

            }
        });
    }


}

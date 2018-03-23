package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.bean.VideoBean;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/03/23.
 */

public class JokeModelImpl implements IJokeModel {
    //获取段子的数据

    @Override
    public void getJokeData(String url, final GetVideoData getVideoData) {
        RetrofitUtil instace = RetrofitUtil.getInstace(url);
        instace.getData(RetrofitService.class).getJokeList().enqueue(new Callback<VideoBean>() {
            @Override
            public void onResponse(Call<VideoBean> call, Response<VideoBean> response) {
                getVideoData.getVideoSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<VideoBean> call, Throwable t) {

            }
        });
    }

}

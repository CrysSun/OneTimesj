package com.bwie.sj.onetime_sj.model;

import android.util.Log;

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

    private static final String TAG = "JokeModelImpl";

    //获取段子的数据
    @Override
    public void getJokeData(int page,String url, final GetJokeListener getJokeListener) {
        RetrofitUtil instace = RetrofitUtil.getInstace(url);
        instace.getData(RetrofitService.class).getJokeList(page).enqueue(new Callback<JokeBean>() {
            @Override
            public void onResponse(Call<JokeBean> call, Response<JokeBean> response) {
                Log.d(TAG, "onResponse: ============" + response.body().getMsg());
                getJokeListener.getJokeList(response.body().getData());
            }

            @Override
            public void onFailure(Call<JokeBean> call, Throwable t) {

            }
        });
    }


}

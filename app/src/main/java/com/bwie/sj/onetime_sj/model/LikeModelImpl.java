package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.CreatBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/04/04.
 */

public class LikeModelImpl implements ILikeModel {
    @Override
    public void getLike(Map<String, String> map, final GetDataListener getDataListener) {

        RetrofitUtils.getInstace(HttpConfig.baseUrl).getData(RetrofitService.class).likeJoke(map).enqueue(new Callback<CreatBean>() {
            @Override
            public void onResponse(Call<CreatBean> call, Response<CreatBean> response) {
                getDataListener.getSuccess(response.body().getMsg());
            }

            @Override
            public void onFailure(Call<CreatBean> call, Throwable t) {
                getDataListener.getError("失败===LikeModelImpl");
            }
        });
    }
}

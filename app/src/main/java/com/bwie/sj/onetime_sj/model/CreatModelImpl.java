package com.bwie.sj.onetime_sj.model;

import android.util.Log;

import com.bwie.sj.onetime_sj.bean.CreatBean;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/03/30.
 */

public class CreatModelImpl implements ICreatModel {
    private static final String TAG = "CreatModelImpl";
    @Override
    public void getCreatjoke(final String jokeFiles, String url, String uid, String token, String content, final GetDataListener getDataListener) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("token", token);
        map.put("content", content);
//        map.put("jokeFiles", jokeFiles+"");
        RetrofitUtils.getInstace(url).getData(RetrofitService.class)
                .creatJoke(map,jokeFiles).enqueue(new Callback<CreatBean>() {
            @Override
            public void onResponse(Call<CreatBean> call, Response<CreatBean> response) {
                Log.d(TAG, "onResponse: ===================="+jokeFiles);
                getDataListener.getSuccess(response.body().getMsg());
            }

            @Override
            public void onFailure(Call<CreatBean> call, Throwable t) {
                getDataListener.getError("失败====CreatModelImpl");
            }
        });
    }
}

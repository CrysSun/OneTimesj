package com.bwie.sj.onetime_sj.model;

import android.net.Uri;

import com.bwie.sj.onetime_sj.bean.CreatBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/03/30.
 */

public class CreatModelImpl implements ICreatModel {
    @Override
    public void getCreatjoke(Uri jokeFiles, String url, String uid, String token, String content, final GetDataListener getDataListener) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("token", token);
        map.put("content", content);
//        map.put("jokeFiles", jokeFiles+"");
        RetrofitUtil.getInstace(url).getData(RetrofitService.class)
                .creatJoke(map,jokeFiles).enqueue(new Callback<CreatBean>() {
            @Override
            public void onResponse(Call<CreatBean> call, Response<CreatBean> response) {
                getDataListener.getSuccess(response.body().getMsg());
            }

            @Override
            public void onFailure(Call<CreatBean> call, Throwable t) {
                getDataListener.getError("失败====CreatModelImpl");
            }
        });
    }
}

package com.bwie.sj.onetime_sj.model;

import android.util.Log;

import com.bwie.sj.onetime_sj.bean.UserLogin;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/03/28.
 */

public class UserLoginImpl implements IUserLoginModel {

    private static final String TAG = "UserLoginImpl";

    //登录
    @Override
    public void showUserLogin(String url, final Map<String, String> params, final GetUidListener getUidListener) {
        Log.d(TAG, "onResponse: ??????????" + params);

        RetrofitUtils.getInstace(HttpConfig.baseUrl).getData(RetrofitService.class)
                .userLogin(url, params).enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                getUidListener.getSuccess(response.body().getMsg(), response.body().getData().getUid() + "", response.body().getData().getToken());

                Log.d(TAG, "onResponse: aaaaaaaaaaaaa" + response.body().getData().getToken());
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                getUidListener.getError("失败");
            }
        });
    }


    //注册
    @Override
    public void showUserReg(String url, Map<String, String> params, final GetDataListener getDataListener) {
        RetrofitUtils.getInstace(HttpConfig.baseUrl).getData(RetrofitService.class)
                .userReg(url, params).enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                getDataListener.getSuccess(response.body().getMsg());
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                getDataListener.getError("失败");
            }
        });
    }
}

package com.bwie.sj.onetime_sj.model;

import android.util.Log;

import com.bwie.sj.onetime_sj.bean.UserLogin;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/03/28.
 */

public class UserLoginImpl implements IUserLoginModel {

    private static final String TAG = "UserLoginImpl";

    @Override
    public void showUserLogin(String url, String mobile, String pwd, final GetDataListener getDataListener) {
        RetrofitUtil instace = RetrofitUtil.getInstace(url);
        instace.getData(RetrofitService.class).userLogin(mobile,pwd).enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                getDataListener.getSuccess(response.body().getMsg());
                Log.d(TAG, "onResponse:============== "+response.body().getMsg());
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                getDataListener.getError("失败");
            }
        });
    }
}

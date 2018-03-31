package com.bwie.sj.onetime_sj.presenter;

import android.util.Log;

import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.GetUidListener;
import com.bwie.sj.onetime_sj.model.IUserLoginModel;
import com.bwie.sj.onetime_sj.views.IShowView;
import com.bwie.sj.onetime_sj.views.IloginView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/03/28.
 */

public class UserLoginPresenter implements IUserLoginPresenter {

    private static final String TAG = "UserLoginPresenter";

    //登录
    @Override
    public void showLoginToView(IUserLoginModel iUserLogin, final IloginView iloginView, String mobile, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", pwd);
        Log.d(TAG, "showLoginToView: ???" + map);
        iUserLogin.showUserLogin(HttpConfig.loginUrl, map, new GetUidListener() {

            @Override
            public void getSuccess(String json, String uid, String token) {
                iloginView.show(json,uid,token);
                Log.d(TAG, "getSuccess: aaaaaaaaaaaaaaaaaaaaaaaa"+json);
            }

            @Override
            public void getError(String error) {
                iloginView.show(error,"","");
            }
        });

    }

    //注册
    @Override
    public void showRegToView(IUserLoginModel iUserLogin, final IShowView iShowView, String mobile, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", pwd);
        iUserLogin.showUserReg(HttpConfig.regUrl, map, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                iShowView.show(json);
            }

            @Override
            public void getError(String error) {
                iShowView.show(error);
            }
        });
    }
}

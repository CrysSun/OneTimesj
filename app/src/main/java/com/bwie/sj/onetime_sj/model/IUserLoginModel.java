package com.bwie.sj.onetime_sj.model;

import java.util.Map;

/**
 * Created by Administrator on 2018/03/28.
 */

public interface IUserLoginModel {
    //用户登录
    void showUserLogin(String url, Map<String, String> params, GetDataListener getDataListener);

    //注册
    void showUserReg(String url, Map<String, String> params, GetDataListener getDataListener);
}

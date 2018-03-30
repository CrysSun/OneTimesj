package com.bwie.sj.onetime_sj.model;

import java.util.Map;

/**
 * Created by Administrator on 2018/03/28.
 */

public interface IUserLoginModel {
    void showUserLogin(String url,String mobile,String pwd, GetDataListener getDataListener);
}

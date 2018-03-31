package com.bwie.sj.onetime_sj.model;

/**
 * 获取uid  token的接口
 * Created by Administrator on 2018/03/30.
 */

public interface GetUidListener {
    void getSuccess(String json,String uid,String token);

    void getError(String error);
}

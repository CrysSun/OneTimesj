package com.bwie.sj.onetime_sj.model;

/**
 * 获取数据是否成功的方法
 * Created by Administrator on 2018/03/22.
 */

public interface GetDataListener {
    void getSuccess(String json);
    void getError(String error);
}

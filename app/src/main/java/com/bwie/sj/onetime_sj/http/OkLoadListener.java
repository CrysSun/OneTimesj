package com.bwie.sj.onetime_sj.http;

/**
 * ok网络请求成功或失败的接口
 * Created by Administrator on 2018/03/22.
 */

public interface OkLoadListener {
    void okLoadSuccess(String json);

    void okLoadErroer(String error);
}

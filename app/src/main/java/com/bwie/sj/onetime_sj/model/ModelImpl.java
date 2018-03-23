package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.http.OkLoadListener;
import com.bwie.sj.onetime_sj.http.OkhttpUtil;
import com.google.gson.Gson;

/**
 * 获取数据
 * Created by Administrator on 2018/03/22.
 */

public class ModelImpl implements IModel {
    //获取广告轮播
    @Override
    public void getAdverSuccess(String url, final GetDataListener getDataListener) {
        OkhttpUtil instance = OkhttpUtil.getInstance();
        //get请求
        instance.okGet(url);
        instance.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                getDataListener.getSuccess(json);
            }

            @Override
            public void okLoadErroer(String error) {
                getDataListener.getSuccess(error);

            }
        });

    }
}

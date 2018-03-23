package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.VideoBean;

import java.util.List;

/**
 * 获取数据
 * Created by Administrator on 2018/03/09.
 */

public interface IModel {
    //获取广告轮播
    void getAdverSuccess(String url, GetDataListener getDataListener);
    //获取广告轮播
    void getVideoSuccess(String url, GetVideoData getVideoData);
}

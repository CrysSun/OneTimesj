package com.bwie.sj.onetime_sj.model;

/**
 * 获取数据
 * Created by Administrator on 2018/03/09.
 */

public interface IHotModel {
    //获取广告轮播
    void getAdverSuccess(String url, GetDataListener getDataListener);
    //获取视频
    void getVideoSuccess(String url, GetVideoListener getVideoListener);
}

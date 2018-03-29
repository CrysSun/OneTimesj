package com.bwie.sj.onetime_sj.model;

/**
 * 获取视频    热门列表
 * Created by Administrator on 2018/03/29.
 */

public interface IViHotModel {
    void getViHotData(String url, int page, GetViHotListener getViHotListener);

    void getViHotError(String error, GetViHotListener getViHotListener);

}

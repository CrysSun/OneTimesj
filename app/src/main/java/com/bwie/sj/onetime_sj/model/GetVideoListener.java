package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.VideoBean;

import java.util.List;

/**
 * 获取视频数据成功  失败
 * Created by Administrator on 2018/03/23.
 */

public interface GetVideoListener {
    void getVideoSuccess(List<VideoBean.DataBean> data);

    void getVideoError(String error);
}

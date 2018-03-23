package com.bwie.sj.onetime_sj.views;

import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.bean.VideoBean;

import java.util.List;

/**
 * 展示的接口
 * Created by Administrator on 2018/03/09.
 */

public interface IHotView {
    //展示轮播图
    void ShowAdvers(List<GgBean.DataBean> data);

    //展示热门的数据    视频列表
    void ShowVideo(List<VideoBean.DataBean> data);

    //错误
    void ShowError(String error);
}

package com.bwie.sj.onetime_sj.views;

import com.bwie.sj.onetime_sj.bean.CoGgBean;
import com.bwie.sj.onetime_sj.bean.CoHotBean;

import java.util.List;

/**
 * 展示的接口
 * Created by Administrator on 2018/03/09.
 */

public interface ICoHotView {
    //展示轮播图
    void ShowAdvers(List<CoGgBean.DataBean> data);

    //展示热门的数据    视频列表
    void ShowVideo(List<CoHotBean.DataBean> data);

    //错误
    void ShowError(String error);
}

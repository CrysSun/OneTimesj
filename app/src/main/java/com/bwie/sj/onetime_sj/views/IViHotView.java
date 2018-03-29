package com.bwie.sj.onetime_sj.views;

import com.bwie.sj.onetime_sj.bean.ViHotBean;

import java.util.List;

/**
 * Created by Administrator on 2018/03/29.
 */

public interface IViHotView {
    void showGrid(List<ViHotBean.DataBean> data);

    void showError(String error);
}

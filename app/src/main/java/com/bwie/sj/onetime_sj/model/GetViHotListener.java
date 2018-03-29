package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.ViHotBean;

import java.util.List;

/**
 * Created by Administrator on 2018/03/29.
 */

public interface GetViHotListener {
    void getViHotList(List<ViHotBean.DataBean> data);

    void getViHotListError(String error);
}

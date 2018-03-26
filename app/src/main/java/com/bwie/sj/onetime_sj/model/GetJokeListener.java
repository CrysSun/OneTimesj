package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.JokeBean;

import java.util.List;

/**
 * 获取段子是否成功的接口
 * Created by Administrator on 2018/03/23.
 */

public interface GetJokeListener {
    void getJokeList(List<JokeBean.DataBean> data);

    void getJokeError(String error);
}

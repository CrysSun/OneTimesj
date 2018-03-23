package com.bwie.sj.onetime_sj.views;

import com.bwie.sj.onetime_sj.bean.JokeBean;

import java.util.List;

/**
 * Created by Administrator on 2018/03/23.
 */

public interface IJokeView {
    void showJokes(List<JokeBean.DataBean> data);

    void showError(String error);
}

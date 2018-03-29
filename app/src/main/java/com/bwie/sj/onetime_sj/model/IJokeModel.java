package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.JokeBean;

import java.util.List;

/**
 * 获取段子的接口
 * Created by Administrator on 2018/03/23.
 */

public interface IJokeModel {
    void getJokeData(int page, String url, GetJokeListener getJokeListener);

    void getJokeError(String error, GetJokeListener getJokeListener);
}

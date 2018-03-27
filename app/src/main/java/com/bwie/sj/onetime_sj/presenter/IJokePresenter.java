package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.IJokeModel;
import com.bwie.sj.onetime_sj.views.IJokeView;

/**
 * Created by Administrator on 2018/03/23.
 */

public interface IJokePresenter {
    //获取数据展示在视图
    void showJokesToVIew(int page,IJokeModel iJokeModel, IJokeView iJokeView);
    //解绑
    void ondetach(IJokeView iJokeView);
}

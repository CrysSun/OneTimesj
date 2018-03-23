package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.IModel;
import com.bwie.sj.onetime_sj.views.IMainView;

/**
 * Created by Administrator on 2018/03/09.
 */

public interface IPresenter {
    //获取轮播数据展示
    void showAdversToview(IModel iModel, IMainView iMainView);
    //获取视频数据展示
    void showVideoToview(IModel iModel, IMainView iMainView);
}

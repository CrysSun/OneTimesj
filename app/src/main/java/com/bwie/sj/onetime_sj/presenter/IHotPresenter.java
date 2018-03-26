package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.IHotModel;
import com.bwie.sj.onetime_sj.views.IHotView;

/**
 * Created by Administrator on 2018/03/09.
 */

public interface IHotPresenter {
    //获取轮播数据展示
    void showAdversToview(IHotModel iModel, IHotView iMainView);
    //获取视频数据展示
    void showVideoToview(IHotModel iModel, IHotView iMainView);
    //解绑
    void ondetach(IHotView view);
}

package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.ICoHotModel;
import com.bwie.sj.onetime_sj.views.ICoHotView;

/**
 * Created by Administrator on 2018/03/09.
 */

public interface ICoHotPresenter {
    //获取轮播数据展示
    void showAdversToview(ICoHotModel iModel, ICoHotView iMainView);
    //获取视频数据展示
    void showVideoToview(int page,ICoHotModel iModel, ICoHotView iMainView);
    //解绑
    void ondetach(ICoHotView view);
}

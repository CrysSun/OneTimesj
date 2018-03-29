package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.IViHotModel;
import com.bwie.sj.onetime_sj.views.IViHotView;

/**
 * Created by Administrator on 2018/03/29.
 */

public interface IViHotPresenter {
    void showViHotToView(int page,IViHotModel iViHotModel, IViHotView iViHotView);
}

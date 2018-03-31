package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.bean.ViHotBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetViHotListener;
import com.bwie.sj.onetime_sj.model.IViHotModel;
import com.bwie.sj.onetime_sj.views.IViHotView;

import java.util.List;

/**
 * Created by Administrator on 2018/03/29.
 */

public class ViHotPresentImpl implements IViHotPresenter {
    @Override
    public void showViHotToView(String userToken,int page, IViHotModel iViHotModel, final IViHotView iViHotView) {
        iViHotModel.getViHotData(HttpConfig.baseUrl,userToken, page, new GetViHotListener() {
            @Override
            public void getViHotList(List<ViHotBean.DataBean> data) {
                iViHotView.showGrid(data);
            }

            @Override
            public void getViHotListError(String error) {
                iViHotView.showError(error);
            }
        });
    }
}

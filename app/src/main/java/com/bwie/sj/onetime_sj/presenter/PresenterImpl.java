package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.IModel;
import com.bwie.sj.onetime_sj.views.IMainView;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2018/03/22.
 */

public class PresenterImpl implements IPresenter {
    //展示广告数据到轮播
    @Override
    public void showAdversToview(IModel iModel, final IMainView iMainView) {
        iModel.getAdverSuccess(HttpConfig.advertiseUrl, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                Gson gson = new Gson();
                GgBean ggBean = gson.fromJson(json, GgBean.class);
                iMainView.ShowAdvers(ggBean.getData());
            }

            @Override
            public void getError(String error) {
                iMainView.ShowError(error);
            }
        });
    }
}

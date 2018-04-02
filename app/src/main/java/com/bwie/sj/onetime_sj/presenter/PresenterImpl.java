package com.bwie.sj.onetime_sj.presenter;

import android.util.Log;

import com.bwie.sj.onetime_sj.bean.CoGgBean;
import com.bwie.sj.onetime_sj.bean.CoHotBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.GetVideoListener;
import com.bwie.sj.onetime_sj.model.ICoHotModel;
import com.bwie.sj.onetime_sj.views.ICoHotView;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2018/03/22.
 */

public class PresenterImpl implements ICoHotPresenter {
    private static final String TAG = "PresenterImpl";

    //展示广告数据到轮播
    @Override
    public void showAdversToview(ICoHotModel iModel, final ICoHotView iHotView) {
        iModel.getAdverSuccess(HttpConfig.advertiseUrl, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                Log.d(TAG, "getSuccess: ============轮播==============" + json);
                Gson gson = new Gson();
                CoGgBean ggBean = gson.fromJson(json, CoGgBean.class);
                iHotView.ShowAdvers(ggBean.getData());
            }

            @Override
            public void getError(String error) {
                iHotView.ShowError(error);
            }
        });
    }

    //展示视频数据
    @Override
    public void showVideoToview(final int page, ICoHotModel iModel, final ICoHotView iHotView) {
        iModel.getVideoSuccess(page, HttpConfig.baseUrl, new GetVideoListener() {
            @Override
            public void getVideoSuccess(List<CoHotBean.DataBean> data) {
                iHotView.ShowVideo(data);
            }

            @Override
            public void getVideoError(String error) {
                iHotView.ShowError(error);
            }
        });
    }

    @Override
    public void ondetach(ICoHotView view) {
        if (view != null) {
            view = null;
        }
    }
}

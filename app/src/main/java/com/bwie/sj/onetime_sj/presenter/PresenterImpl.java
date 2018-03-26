package com.bwie.sj.onetime_sj.presenter;

import android.util.Log;

import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.bean.VideoBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.GetVideoListener;
import com.bwie.sj.onetime_sj.model.IHotModel;
import com.bwie.sj.onetime_sj.views.IHotView;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2018/03/22.
 */

public class PresenterImpl implements IHotPresenter {
    private static final String TAG = "PresenterImpl";

    //展示广告数据到轮播
    @Override
    public void showAdversToview(IHotModel iModel, final IHotView iHotView) {
        iModel.getAdverSuccess(HttpConfig.advertiseUrl, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                Log.d(TAG, "getSuccess: ============轮播==============" + json);
                Gson gson = new Gson();
                GgBean ggBean = gson.fromJson(json, GgBean.class);
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
    public void showVideoToview(IHotModel iModel, final IHotView iHotView) {
        iModel.getVideoSuccess(HttpConfig.baseUrl, new GetVideoListener() {
            @Override
            public void getVideoSuccess(List<VideoBean.DataBean> data) {
                iHotView.ShowVideo(data);
            }

            @Override
            public void getVideoError(String error) {
                iHotView.ShowError(error);
            }
        });
    }

    @Override
    public void ondetach(IHotView view) {
        if (view != null) {
            view = null;
        }
    }
}
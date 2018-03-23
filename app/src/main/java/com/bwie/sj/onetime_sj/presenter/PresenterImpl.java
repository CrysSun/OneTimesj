package com.bwie.sj.onetime_sj.presenter;

import android.util.Log;

import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.bean.VideoBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.GetVideoData;
import com.bwie.sj.onetime_sj.model.IModel;
import com.bwie.sj.onetime_sj.views.IMainView;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2018/03/22.
 */

public class PresenterImpl implements IPresenter {
    private static final String TAG = "PresenterImpl";

    //展示广告数据到轮播
    @Override
    public void showAdversToview(IModel iModel, final IMainView iMainView) {
        iModel.getAdverSuccess(HttpConfig.advertiseUrl, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                Log.d(TAG, "getSuccess: ============轮播==============" + json);
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

    //展示视频数据
    @Override
    public void showVideoToview(IModel iModel, final IMainView iMainView) {
        iModel.getVideoSuccess(HttpConfig.baseUrl, new GetVideoData() {
            @Override
            public void getVideoSuccess(List<VideoBean.DataBean> data) {
                iMainView.ShowVideo(data);
            }

            @Override
            public void getVideoError(String error) {
                iMainView.ShowError(error);
            }
        });
    }
}

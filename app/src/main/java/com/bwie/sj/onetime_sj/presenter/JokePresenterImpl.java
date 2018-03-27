package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetJokeListener;
import com.bwie.sj.onetime_sj.model.IJokeModel;
import com.bwie.sj.onetime_sj.views.IJokeView;

import java.util.List;

/**
 * Created by Administrator on 2018/03/23.
 */

public class JokePresenterImpl implements IJokePresenter {
    @Override
    public void showJokesToVIew(int page,IJokeModel iJokeModel, final IJokeView iJokeView) {
        iJokeModel.getJokeData(page,HttpConfig.baseUrl, new GetJokeListener() {
            @Override
            public void getJokeList(List<JokeBean.DataBean> data) {
                iJokeView.showJokes(data);
            }

            @Override
            public void getJokeError(String error) {
                iJokeView.showError(error);
            }
        });
    }

    @Override
    public void ondetach(IJokeView iJokeView) {
        if (iJokeView!=null){
            iJokeView=null;
        }
    }
}

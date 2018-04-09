package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.ILikeModel;
import com.bwie.sj.onetime_sj.views.IShowView;

/**
 * Created by Administrator on 2018/04/04.
 */

public interface ILikePresenter {
    void showLikeToView(String uid, String token, String wid, ILikeModel iLikeModel,IShowView iShowView);
}

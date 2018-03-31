package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.ICreatModel;
import com.bwie.sj.onetime_sj.views.IShowView;
import com.bwie.sj.onetime_sj.views.IloginView;

/**
 * Created by Administrator on 2018/03/30.
 */

public interface ICreatPresenter {
    void showCreatToView( String uid, String token, String content, ICreatModel iCreatModel, IShowView iShowView);
}

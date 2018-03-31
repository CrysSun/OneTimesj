package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.ICreatModel;
import com.bwie.sj.onetime_sj.views.IShowView;
import com.bwie.sj.onetime_sj.views.IloginView;

/**
 * Created by Administrator on 2018/03/30.
 */

public class CreatPresenterImpl implements ICreatPresenter {
    @Override
    public void showCreatToView(String uid, String token, String content, ICreatModel iCreatModel, final IShowView iShowView) {
        iCreatModel.getCreatjoke(HttpConfig.baseUrl, uid, token, content, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                iShowView.show(json);
            }

            @Override
            public void getError(String error) {
                iShowView.show(error);
            }
        });
    }
}

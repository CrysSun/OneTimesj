package com.bwie.sj.onetime_sj.presenter;

import android.net.Uri;
import android.util.Log;

import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.ICreatModel;
import com.bwie.sj.onetime_sj.views.IShowView;
import com.bwie.sj.onetime_sj.views.IloginView;

/**
 * Created by Administrator on 2018/03/30.
 */

public class CreatPresenterImpl implements ICreatPresenter {
    private static final String TAG = "CreatPresenterImpl";
    @Override
    public void showCreatToView(final Uri imagFile, String uid, String token, String content, ICreatModel iCreatModel, final IShowView iShowView) {
        iCreatModel.getCreatjoke(imagFile,HttpConfig.baseUrl, uid, token, content, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                Log.d(TAG, "getSuccess: ??????????"+imagFile+"//////////"+json);
                iShowView.show(json);
            }

            @Override
            public void getError(String error) {
                iShowView.show(error);
            }
        });
    }
}

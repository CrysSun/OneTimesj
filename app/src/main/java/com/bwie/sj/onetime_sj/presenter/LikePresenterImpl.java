package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.ILikeModel;
import com.bwie.sj.onetime_sj.views.IShowView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/04/04.
 */

public class LikePresenterImpl implements ILikePresenter {
    @Override
    public void showLikeToView(String uid, String token, String wid, ILikeModel iLikeModel, final IShowView iShowView) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("token", token);
        map.put("wid", wid);
        iLikeModel.getLike(map, new GetDataListener() {
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

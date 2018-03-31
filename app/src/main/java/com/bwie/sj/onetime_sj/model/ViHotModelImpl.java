package com.bwie.sj.onetime_sj.model;

import com.bwie.sj.onetime_sj.bean.ViHotBean;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/03/29.
 */

public class ViHotModelImpl implements IViHotModel {
    @Override
    public void getViHotData(String url,String userToken, int page, final GetViHotListener getViHotListener) {
        RetrofitUtil instace = RetrofitUtil.getInstace(url);
        instace.getData(RetrofitService.class).getViHotList(page,userToken).enqueue(new Callback<ViHotBean>() {
            @Override
            public void onResponse(Call<ViHotBean> call, Response<ViHotBean> response) {
                getViHotListener.getViHotList(response.body().getData());
            }

            @Override
            public void onFailure(Call<ViHotBean> call, Throwable t) {
                getViHotListener.getViHotListError("网络请求失败");
            }
        });
    }

    @Override
    public void getViHotError(String error, GetViHotListener getViHotListener) {
        getViHotListener.getViHotListError(error);
    }
}

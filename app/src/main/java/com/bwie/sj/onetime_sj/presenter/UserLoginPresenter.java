package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.model.GetDataListener;
import com.bwie.sj.onetime_sj.model.IUserLogin;
import com.bwie.sj.onetime_sj.views.IloginView;

/**
 * Created by Administrator on 2018/03/28.
 */

public class UserLoginPresenter implements IUserLoginPresenter {

    @Override
    public void showLoginToView(IUserLogin iUserLogin, final IloginView iloginView, String mobile, String pwd) {
        iUserLogin.showUserLogin(HttpConfig.baseUrl, mobile, pwd, new GetDataListener() {
            @Override
            public void getSuccess(String json) {
                iloginView.show(json);
            }

            @Override
            public void getError(String error) {
                iloginView.show(error);
            }
        });

    }
}

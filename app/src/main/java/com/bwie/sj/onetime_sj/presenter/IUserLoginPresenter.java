package com.bwie.sj.onetime_sj.presenter;

import com.bwie.sj.onetime_sj.model.IUserLoginModel;
import com.bwie.sj.onetime_sj.views.IloginView;

/**
 * Created by Administrator on 2018/03/28.
 */

public interface IUserLoginPresenter {
    void showLoginToView(IUserLoginModel iUserLogin, IloginView iloginView, String mobile, String pwd);
}

package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.http.HttpConfig;
import com.bwie.sj.onetime_sj.http.OkLoadListener;
import com.bwie.sj.onetime_sj.http.OkhttpUtil;
import com.bwie.sj.onetime_sj.http.RetrofitService;
import com.bwie.sj.onetime_sj.http.RetrofitUtil;
import com.bwie.sj.onetime_sj.model.ModelImpl;
import com.bwie.sj.onetime_sj.presenter.PresenterImpl;
import com.bwie.sj.onetime_sj.views.IMainView;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 热门的界面
 * Created by Administrator on 2018/03/21.
 */

public class HotFragment extends Fragment implements IMainView {
    private static final String TAG = "HotFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hot, null);
        //初始化presenter
        PresenterImpl presenter = new PresenterImpl();
        presenter.showAdversToview(new ModelImpl(),this);
        return view;
    }

    @Override
    public void ShowAdvers(List<GgBean.DataBean> list) {
        Log.d(TAG, "ShowAdvers: =============="+list);
    }

    @Override
    public void ShowError(String error) {
        Toast.makeText(getActivity(), "======"+error, Toast.LENGTH_SHORT).show();
    }
}

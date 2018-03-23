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
import com.bwie.sj.onetime_sj.bean.VideoBean;
import com.bwie.sj.onetime_sj.model.ModelImpl;
import com.bwie.sj.onetime_sj.presenter.PresenterImpl;
import com.bwie.sj.onetime_sj.views.IMainView;
import com.bwie.sj.onetime_sj.views.viewself.Banner;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 热门的界面
 * Created by Administrator on 2018/03/21.
 */

public class HotFragment extends Fragment implements IMainView {
    private static final String TAG = "HotFragment";
    //    @BindView(R.id.banner)
//    Banner banner;
    private XRecyclerView xrecler;
    private Banner banner;
    private PresenterImpl presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hot, null);
//        ButterKnife.bind(this, view);
        xrecler = view.findViewById(R.id.hot_xrecler);
        //初始化presenter
        presenter = new PresenterImpl();
        init();
        presenter.showVideoToview(new ModelImpl(), this);
        return view;
    }

    private void init() {
        initView();
        initData();

    }

    private void initData() {
        //调用轮播
        presenter.showAdversToview(new ModelImpl(), this);
    }

    private void initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.hot_banner, null);
        banner = view.findViewById(R.id.banner);
        xrecler.addHeaderView(view);
    }

    @Override
    public void ShowAdvers(List<GgBean.DataBean> list) {
        //获取图片的集合
        List<String> iconList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String icon = list.get(i).getIcon();
            iconList.add(icon);
        }
        Log.d(TAG, "ShowAdvers: ++++++++++++++++" + iconList);
        banner.loadData(iconList);
    }

    //展示视频列表数据
    @Override
    public void ShowVideo(List<VideoBean.DataBean> list) {
        Log.d(TAG, "ShowHotData: ===============视频列表+++++++++++" + list);
        //设置适配器
//        xrecler.setAdapter();
    }


    @Override
    public void ShowError(String error) {
        Toast.makeText(getActivity(), "======" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (banner != null) {
            banner.cancel();
            banner = null;
        }
    }
}

package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.adapter.CoHotXreclerAdapter;
import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.bean.VideoBean;
import com.bwie.sj.onetime_sj.model.ModelImpl;
import com.bwie.sj.onetime_sj.presenter.PresenterImpl;
import com.bwie.sj.onetime_sj.views.IHotView;
import com.bwie.sj.onetime_sj.views.viewself.Banner;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐的热门的界面
 * Created by Administrator on 2018/03/21.
 */

public class HotFragment extends Fragment implements IHotView {
    private static final String TAG = "HotFragment";
    private XRecyclerView xrecler;
    private Banner banner;
    private PresenterImpl presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //初始化界面
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hot, null);
        xrecler = view.findViewById(R.id.hot_xrecler);
        //初始化轮播布局
        initView();
        return view;
    }

    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            initData();
        }
    }


    //初始化presenter
    private void initData() {
        presenter = new PresenterImpl();
        //调用轮播广告展示
        presenter.showAdversToview(new ModelImpl(), this);
        //调用推荐界面热门视频展示
        presenter.showVideoToview(new ModelImpl(), this);
    }


    private void initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.hot_banner, null);
        //xrecler    添加头布局           ===========
        xrecler.addHeaderView(view);
        banner = view.findViewById(R.id.banner);

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
        //banner加载数据
        banner.loadData(iconList).display();

    }

    //展示视频列表数据
    @Override
    public void ShowVideo(List<VideoBean.DataBean> list) {
        Log.d(TAG, "ShowHotData: ===============视频列表+++++++++++" + list);
        //设置适配器    xrecycler
        CoHotXreclerAdapter adapter = new CoHotXreclerAdapter(getActivity(), list);
        xrecler.setAdapter(adapter);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrecler.setLayoutManager(linearLayoutManager);
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
        if (presenter != null) {
            presenter.ondetach(this);
//            presenter = null;
        }
    }
}

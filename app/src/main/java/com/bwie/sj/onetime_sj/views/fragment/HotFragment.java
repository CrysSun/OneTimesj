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
import com.bwie.sj.onetime_sj.bean.CoGgBean;
import com.bwie.sj.onetime_sj.bean.CoHotBean;
import com.bwie.sj.onetime_sj.model.ModelImpl;
import com.bwie.sj.onetime_sj.presenter.PresenterImpl;
import com.bwie.sj.onetime_sj.views.ICoHotView;
import com.bwie.sj.onetime_sj.views.viewself.Banner;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐的热门的界面
 * Created by Administrator on 2018/03/21.
 */

public class HotFragment extends Fragment implements ICoHotView {
    private static final String TAG = "HotFragment";
    private XRecyclerView xrecler;
    private Banner banner;
    private PresenterImpl presenter;
    private int page = 1;
    private CoHotXreclerAdapter coHotXreclerAdapter;
    private List<CoHotBean.DataBean> listAll = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //初始化界面
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hot, null);
        xrecler = view.findViewById(R.id.hot_xrecler);
        //初始化轮播布局
        initView();
        getData(1);
        //上下拉刷新
        pull();
        return view;
    }

    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //初始化presenter
            presenter = new PresenterImpl();
            //调用轮播广告展示
            presenter.showAdversToview(new ModelImpl(), this);
            //加载第一遍
            getData(1);
        }
    }

    private void pull() {
        xrecler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                listAll.clear();
                page = 1;
                getData(page);
                xrecler.refreshComplete();
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                ++page;
                getData(page);
                xrecler.loadMoreComplete();
                Toast.makeText(getActivity(), "加载更多"+page, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //初始化presenter
    private void getData(int pages) {
        //调用推荐界面热门视频展示
        presenter.showVideoToview(pages, new ModelImpl(), this);
    }


    private void initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.hot_banner, null);
        banner = view.findViewById(R.id.banner);
        //xrecler    添加头布局           ===========
        xrecler.addHeaderView(view);
    }


    @Override
    public void ShowAdvers(List<CoGgBean.DataBean> list) {
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
    public void ShowVideo(List<CoHotBean.DataBean> list) {
        listAll.addAll(list);
        Log.d(TAG, "ShowHotData: ===============视频列表+++++++++++" + list);
        //设置适配器    xrecycler
        if (coHotXreclerAdapter == null) {
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            xrecler.setLayoutManager(linearLayoutManager);
            //设置适配器
            coHotXreclerAdapter = new CoHotXreclerAdapter(getActivity(), list);
            xrecler.setAdapter(coHotXreclerAdapter);
        } else {
            //刷新适配器
            coHotXreclerAdapter.notifyDataSetChanged();
        }

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

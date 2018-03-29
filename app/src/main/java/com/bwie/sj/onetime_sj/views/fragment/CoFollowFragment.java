package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.adapter.CoHotXreclerAdapter;
import com.bwie.sj.onetime_sj.bean.CoGgBean;
import com.bwie.sj.onetime_sj.bean.CoHotBean;
import com.bwie.sj.onetime_sj.model.ModelImpl;
import com.bwie.sj.onetime_sj.presenter.PresenterImpl;
import com.bwie.sj.onetime_sj.views.ICoHotView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * 关注的界面
 * Created by Administrator on 2018/03/21.
 */

public class CoFollowFragment extends Fragment implements ICoHotView {

    private XRecyclerView xrecler;
    private static final String TAG = "CoFollowFragment";
    private PresenterImpl presenter;
    private CoHotXreclerAdapter coHotXreclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_follow, null);
        xrecler = view.findViewById(R.id.cofollow_xrecler);
        //初始化头布局
        initView();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //界面用户可见
            presenter = new PresenterImpl();
            //调用轮播广告展示
            presenter.showAdversToview(new ModelImpl(), this);
            //加载第一遍
            getData(1);
        }
    }

    //初始化presenter
    private void getData(int pages) {
        //调用推荐界面热门视频展示
        presenter.showVideoToview(pages, new ModelImpl(), this);
    }

    /**
     * 添加头布局
     */
    private void initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.cofoloowicon, null);
        xrecler.addHeaderView(inflate);
    }

    @Override
    public void ShowAdvers(List<CoGgBean.DataBean> data) {

    }

    @Override
    public void ShowVideo(List<CoHotBean.DataBean> list) {
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
        Log.d(TAG, "ShowHotData: ===============视频列表+++++++++++" + error);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.ondetach(this);
        }
    }
}

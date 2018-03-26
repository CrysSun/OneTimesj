package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.adapter.TableAdapter;
import com.bwie.sj.onetime_sj.base.MyApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 推荐的fragment
 * Created by Administrator on 2018/03/13.
 */

public class CommendFragment extends Fragment {
    @BindView(R.id.commend_tabl)
    TabLayout commendTabl;
    @BindView(R.id.commend_vp)
    ViewPager commend_vp;
    Unbinder unbinder;

    private static final String TAG = "CommendFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_commend, null);
        unbinder = ButterKnife.bind(this, view);
        List<String> list = new ArrayList<>();
        list.add("热门");
        list.add("关注");
        //设置顶部导航栏适配器
        TableAdapter tableAdapter = new TableAdapter(getFragmentManager(), getActivity(), list);
        commend_vp.setAdapter(tableAdapter);
        //tab与vp的关联
        commendTabl.setupWithViewPager(commend_vp);
        //监听
//        commendTabl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

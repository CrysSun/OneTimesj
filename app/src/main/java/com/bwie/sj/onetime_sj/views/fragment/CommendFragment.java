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
//        //设置标题
//        commendTabl.addTab(commendTabl.newTab().setText("热门"),true);
//        commendTabl.addTab(commendTabl.newTab().setText("关注"));
        ArrayList<String> list = new ArrayList<>();
        list.add("热门");
        list.add("关注");
        //设置适配器
        commend_vp.setAdapter(new TableAdapter(getFragmentManager(),list,getActivity()));
        commendTabl.setupWithViewPager(commend_vp);
        //监听
        commendTabl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

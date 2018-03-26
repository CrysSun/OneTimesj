package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.adapter.CoHotTableAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 视频的fragment
 * Created by Administrator on 2018/03/13.
 */

public class VideoFragment extends Fragment {
    @BindView(R.id.video_tabl)
    TabLayout videoTabl;
    @BindView(R.id.video_vp)
    ViewPager videoVp;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> list = new ArrayList<>();
        list.add("热门");
        list.add("附近");
        //设置适配器
        videoVp.setAdapter(new CoHotTableAdapter(getFragmentManager(), getActivity(), list));
        //tabl与vp的关联
        videoTabl.setupWithViewPager(videoVp);
    }

    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

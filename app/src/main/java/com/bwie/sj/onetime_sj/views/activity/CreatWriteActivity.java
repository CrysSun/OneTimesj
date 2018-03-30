package com.bwie.sj.onetime_sj.views.activity;

import android.os.Bundle;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;

import butterknife.ButterKnife;

public class CreatWriteActivity extends BaseAcrivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creat_write);
        ButterKnife.bind(this);

    }

    @Override
    protected int bindLayout() {
        return R.layout.creat_write;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //设置沉浸式状态栏
        setStatus(true);
        //是否显示actionbar
        setShowActionBar(false);
        //是否全屏
        setFullScreen(true);
    }

}

package com.bwie.sj.onetime_sj.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.bwie.sj.onetime_sj.R;

public class MainActivity extends BaseAcrivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //测试--
        //和好覅是否合适
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
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
    //定义退出的标识
//    boolean flag = false;
//    @Override
//    public boolean onKeyUp(int keyCode, KeyEvent event) {
//
//        return super.onKeyUp(keyCode, event);
//    }
}

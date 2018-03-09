package com.bwie.sj.onetime_sj.views.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by Administrator on 2018/03/09.
 */

public abstract class BaseAcrivity extends AppCompatActivity {
    private boolean isStatus = false;//沉浸式透明状态栏标示
    private boolean isShowActionBar = true;//是否隐藏actionbar
    private boolean isFullScreen = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(bindLayout());
        initView();
        initData();

    }

    protected abstract int bindLayout();//绑定布局

    protected abstract void initView();//初始化控件

    protected abstract void initData();//初始化数据


    public void setStatus(boolean status) {
        isStatus = status;
        if (isStatus) {
            //判断当前设备的版本号》=19的时候，走这个代码块，这个用于版本适配
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    /**
     * 沉浸式AnctionBar
     *
     * @param showActionBar
     */
    public void setShowActionBar(boolean showActionBar) {
        isShowActionBar = showActionBar;

        if (isShowActionBar) {
            getSupportActionBar().show();
        } else {
            getSupportActionBar().hide();
        }
    }

    /**
     * 沉浸式状态栏
     *
     * @param fullScreen
     */
    public void setFullScreen(boolean fullScreen) {
        isFullScreen = fullScreen;
        if (isFullScreen) {//是全屏的时候
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}

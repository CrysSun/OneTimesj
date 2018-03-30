package com.bwie.sj.onetime_sj.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreatActivity extends BaseAcrivity {

    @BindView(R.id.creat_back)
    TextView creatBack;
    @BindView(R.id.creat_tv)
    TextView creatTv;
    @BindView(R.id.creat_video)
    LinearLayout creatVideo;
    @BindView(R.id.creat_write)
    LinearLayout creatWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);
        ButterKnife.bind(this);

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_creat;
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

    @OnClick({R.id.creat_back, R.id.creat_video, R.id.creat_write})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.creat_back://主界面
                startActivity(new Intent(CreatActivity.this, MainActivity.class));
                break;
            case R.id.creat_video://拍摄视频
                break;
            case R.id.creat_write://发布端子
                //跳到写段子的界面CreatWriteActivity
//                startActivity(new Intent(CreatActivity.this, CreatWriteActivity.class));

                break;
        }
    }
}

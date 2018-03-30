package com.bwie.sj.onetime_sj.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindPwdActivity extends BaseAcrivity {

    @BindView(R.id.find_back)
    ImageView findBack;
    @BindView(R.id.find_or)
    TextView findOr;
    @BindView(R.id.find_black)
    ImageView findBlack;
    @BindView(R.id.find_account)
    EditText findAccount;
    @BindView(R.id.find_getcode)
    TextView findGetcode;
    @BindView(R.id.find_pwd)
    EditText findPwd;
    @BindView(R.id.find_start)
    Button findStart;
    @BindView(R.id.find_youke)
    TextView findYouke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd);
        ButterKnife.bind(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_find_pwd;
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

    @OnClick({R.id.find_back, R.id.find_or, R.id.find_black, R.id.find_account, R.id.find_getcode, R.id.find_pwd, R.id.find_start, R.id.find_youke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.find_back://返回登录界面
                startActivity(new Intent(FindPwdActivity.this, OthLogActivity.class));
                break;
            case R.id.find_or://返回登录界面
                startActivity(new Intent(FindPwdActivity.this, OthLogActivity.class));
                break;
            case R.id.find_black:
                break;
            case R.id.find_account:
                break;
            case R.id.find_getcode:
                break;
            case R.id.find_pwd:
                break;
            case R.id.find_start:
                break;
            case R.id.find_youke://跳到主界面
                startActivity(new Intent(FindPwdActivity.this,MainActivity.class));
                break;
        }
    }
}

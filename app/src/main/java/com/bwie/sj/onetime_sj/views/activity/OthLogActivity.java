package com.bwie.sj.onetime_sj.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;
import com.bwie.sj.onetime_sj.model.UserLoginImpl;
import com.bwie.sj.onetime_sj.presenter.UserLoginPresenter;
import com.bwie.sj.onetime_sj.views.IloginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OthLogActivity extends BaseAcrivity implements IloginView {

    @BindView(R.id.other_back)
    ImageView otherBack;
    @BindView(R.id.other_reg)
    TextView otherReg;
    @BindView(R.id.other_black)
    ImageView otherBlack;
    @BindView(R.id.other_account)
    EditText otherAccount;
    @BindView(R.id.other_pwd)
    EditText otherPwd;
    @BindView(R.id.other_login)
    Button otherLogin;
    @BindView(R.id.other_forget)
    TextView otherForget;
    @BindView(R.id.other_youke)
    TextView otherYouke;
    private UserLoginPresenter userLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oth_log);
        ButterKnife.bind(this);
        userLoginPresenter = new UserLoginPresenter();

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_oth_log;
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

    @OnClick({R.id.other_back, R.id.other_reg, R.id.other_black, R.id.other_account, R.id.other_pwd, R.id.other_login, R.id.other_forget, R.id.other_youke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.other_back:
                break;
            case R.id.other_reg://注册账号
                startActivity(new Intent(OthLogActivity.this, RegActivity.class));
                //退出动画
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
            case R.id.other_black:
                break;
            case R.id.other_account:
                break;
            case R.id.other_pwd:
                break;
            case R.id.other_login://跳到主界面
                initLogin();
                break;
            case R.id.other_forget://跳到z找回密码界面
                startActivity(new Intent(OthLogActivity.this, FindPwdActivity.class));
                break;
            case R.id.other_youke://跳到主界面
                startActivity(new Intent(OthLogActivity.this, MainActivity.class));
                break;
        }
    }

    private void initLogin() {
        userLoginPresenter.showLoginToView(new UserLoginImpl(),this,otherAccount.getText()+"",otherPwd.getText()+"");

        startActivity(new Intent(OthLogActivity.this, MainActivity.class));
    }

    @Override
    public void show(String msg) {
        Toast.makeText(this, msg + "++", Toast.LENGTH_SHORT).show();
    }
}

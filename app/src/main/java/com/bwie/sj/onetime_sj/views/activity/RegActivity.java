package com.bwie.sj.onetime_sj.views.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.bwie.sj.onetime_sj.views.IShowView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册界面
 */
public class RegActivity extends BaseAcrivity implements IShowView {

    @BindView(R.id.reg_back)
    ImageView regBack;
    @BindView(R.id.reg_or)
    TextView regOr;
    @BindView(R.id.reg_black)
    ImageView regBlack;
    @BindView(R.id.reg_account)
    EditText regAccount;
    @BindView(R.id.reg_pwd)
    EditText regPwd;
    @BindView(R.id.reg_start)
    Button regStart;
    @BindView(R.id.reg_youke)
    TextView regYouke;
    private UserLoginPresenter userLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_reg;
    }

    @Override
    protected void initView() {
        userLoginPresenter = new UserLoginPresenter();
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

    @OnClick({R.id.reg_back, R.id.reg_or, R.id.reg_black, R.id.reg_account, R.id.reg_pwd, R.id.reg_start, R.id.reg_youke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reg_back:
                startActivity(new Intent(RegActivity.this, OthLogActivity.class));
                finish();
                break;
            case R.id.reg_or://跳到登录界面
                startActivity(new Intent(RegActivity.this, OthLogActivity.class));
                finish();
                break;
            case R.id.reg_black:
                break;
            case R.id.reg_account:
                break;
            case R.id.reg_pwd:
                break;
            case R.id.reg_start://跳到登录界面
                initReg();

                break;
            case R.id.reg_youke://跳到主界面
                startActivity(new Intent(RegActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    /**
     * 注册账号
     */
    private void initReg() {
        String loginPhone = regAccount.getText().toString().trim();
        String loginPwd = regPwd.getText().toString().trim();
        if (loginPhone.equals("") || loginPwd.equals("")) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();

        } else {
            userLoginPresenter.showRegToView(new UserLoginImpl(), this, loginPhone, loginPwd);

        }
    }

    //注册
    @Override
    public void show(String msg) {
        if (msg.equals("注册成功")) {
            startActivity(new Intent(RegActivity.this, OthLogActivity.class));
            //退出动画
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
            Toast.makeText(this, msg + "!!", Toast.LENGTH_SHORT).show();
        } else {
            regAccount.setText("");
            regPwd.setText("");
            Toast.makeText(this, msg + "??", Toast.LENGTH_SHORT).show();
        }
    }
}

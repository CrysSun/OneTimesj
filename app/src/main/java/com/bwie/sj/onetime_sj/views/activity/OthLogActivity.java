package com.bwie.sj.onetime_sj.views.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;
import com.bwie.sj.onetime_sj.bean.UserInfoBean;
import com.bwie.sj.onetime_sj.model.UserLoginImpl;
import com.bwie.sj.onetime_sj.presenter.UserLoginPresenter;
import com.bwie.sj.onetime_sj.views.IloginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

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
    private static final String TAG = "OthLogActivity";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oth_log);
        ButterKnife.bind(this);
        //初始化sp
        sp = getSharedPreferences("userlogin", Context.MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", false);
        //如果为true表示已登录   直接跳转
        if (flag) {
            startActivity(new Intent(new Intent(OthLogActivity.this, MainActivity.class)));
        }
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_oth_log;
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

    @OnClick({R.id.other_back, R.id.other_reg, R.id.other_black, R.id.other_account, R.id.other_pwd, R.id.other_login, R.id.other_forget, R.id.other_youke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.other_back://返回
                startActivity(new Intent(OthLogActivity.this, LoginActivity.class));
                finish();
                break;
            case R.id.other_reg://注册账号
                startActivity(new Intent(OthLogActivity.this, RegActivity.class));
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

    /**
     * 登录
     */
    @SuppressLint("CommitPrefEdits")
    private void initLogin() {
        String loginPhone = otherAccount.getText().toString().trim();
        String loginPwd = otherPwd.getText().toString().trim();
        if (loginPhone.equals("") || loginPwd.equals("")) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();

        } else {
            userLoginPresenter.showLoginToView(new UserLoginImpl(), this, loginPhone, loginPwd);

        }
    }

    //登录
    @Override
    public void show(String msg, String uid, String token) {
        if (msg.equals("登录成功")) {
            //sp存取值                 =================================
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("flag", true);
            edit.putString("uid", uid);
            edit.putString("token", token);

            edit.commit();


            //eventbus传值
            UserInfoBean userInfoBean = new UserInfoBean(uid, token);
            EventBus.getDefault().postSticky(userInfoBean);
            Log.d(TAG, "show:????????? " + userInfoBean.getUid());
            startActivity(new Intent(OthLogActivity.this, MainActivity.class));
            finish();
            Toast.makeText(this, msg + "!!", Toast.LENGTH_SHORT).show();
        } else {
            otherAccount.setText("");
            otherPwd.setText("");
            Toast.makeText(this, msg + "??", Toast.LENGTH_SHORT).show();
        }
    }
}

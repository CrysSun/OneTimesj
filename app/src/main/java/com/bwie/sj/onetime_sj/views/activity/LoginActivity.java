package com.bwie.sj.onetime_sj.views.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 */
public class LoginActivity extends BaseAcrivity {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.login_black)
    ImageView loginBlack;
    @BindView(R.id.login_wechat)
    LinearLayout loginWechat;
    @BindView(R.id.login_qq)
    LinearLayout loginQq;
    @BindView(R.id.login_other)
    TextView loginOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //如果大于或等于23，需要做权限的动态申请：
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        ButterKnife.bind(this);
//        -----------------------

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
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

    @OnClick({R.id.login_back, R.id.login_black, R.id.login_wechat, R.id.login_qq, R.id.login_other})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back://返回
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.login_black:
                break;
            case R.id.login_wechat://微信登录.
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.login_qq://QQ登录
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.login_other://其他登录
                startActivity(new Intent(LoginActivity.this, OthLogActivity.class));
                //退出动画
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
}

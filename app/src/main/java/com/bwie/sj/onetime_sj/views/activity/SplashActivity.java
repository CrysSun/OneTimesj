package com.bwie.sj.onetime_sj.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bwie.sj.onetime_sj.R;

/**
 * 闪屏界面
 */
public class SplashActivity extends AppCompatActivity {

    private ImageView splash_icon;

    private MyHandler myHandler = new MyHandler();
    private class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //收到消息   不做处理

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //初始化界面
        initView();
        //延时3秒   发送空消息
        myHandler.sendEmptyMessageDelayed(0,3000);
        //跳转界面   结束
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
    }

    private void initView() {
        splash_icon = (ImageView) findViewById(R.id.splash_icon);
    }
}
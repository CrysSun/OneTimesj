package com.bwie.sj.onetime_sj.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;
import com.bwie.sj.onetime_sj.bean.UserInfoBean;
import com.bwie.sj.onetime_sj.model.CreatModelImpl;
import com.bwie.sj.onetime_sj.presenter.CreatPresenterImpl;
import com.bwie.sj.onetime_sj.views.IShowView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class CreatWriteActivity extends BaseAcrivity implements IShowView {


    @BindView(R.id.writ_back)
    TextView writBack;
    @BindView(R.id.writ_tv)
    TextView writTv;
    @BindView(R.id.creat_start)
    TextView creatStart;
    @BindView(R.id.writ_msg)
    EditText writMsg;
    @BindView(R.id.writ_jia)
    ImageView writJia;

    private  String userUid;
    private  String userToken;
    private static final String TAG = "CreatWriteActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creat_write);
        ButterKnife.bind(this);
        //注册eventbus
        EventBus.getDefault().register(this);
    }

    //接收eventbus传过来的值
    @Subscribe(threadMode = ThreadMode.MainThread,sticky = true)
    public void  onNewsEvent(UserInfoBean userInfoBean){
        this.userUid=userInfoBean.getUid();
        this.userToken=userInfoBean.getToken();
    }
    //沉浸式绑定
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

    @OnClick({R.id.writ_back, R.id.creat_start, R.id.writ_jia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.writ_back:
                startActivity(new Intent(CreatWriteActivity.this, CreatActivity.class));
                break;
            case R.id.creat_start:
                initStart();
                break;
            case R.id.writ_jia:
                break;
        }
    }

    //发表
    private void initStart() {
        //intent传值
        String content = writMsg.getText().toString().trim();
        //presenter的调用
        CreatPresenterImpl creatPresenter = new CreatPresenterImpl();
        Log.d(TAG, "initStart: zzzzzzzzzzzzzzzzzzzzzzzz"+userToken);
        creatPresenter.showCreatToView(userUid, userToken, content, new CreatModelImpl(), this);
    }

    //发布展示的方法
    @Override
    public void show(String msg) {
        if (msg.equals("发布成功")) {
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, msg + "??", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑eventbus
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }
}

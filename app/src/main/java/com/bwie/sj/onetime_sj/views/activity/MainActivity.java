package com.bwie.sj.onetime_sj.views.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;
import com.bwie.sj.onetime_sj.views.fragment.CommendFragment;
import com.bwie.sj.onetime_sj.views.fragment.JokesFragment;
import com.bwie.sj.onetime_sj.views.fragment.VideoFragment;
import com.bwie.sj.onetime_sj.views.viewself.TitleView;
import com.bwie.sj.slidingmenu.SlidingMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseAcrivity implements TitleView.OnClickImage {

    @BindView(R.id.main_head_title)
    TitleView mainHeadTitle;
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.main_iv_commend)
    ImageView mainIvCommend;
    @BindView(R.id.main_rb_commend)
    RadioButton mainRbCommend;
    @BindView(R.id.main_iv_jokes)
    ImageView mainIvJokes;
    @BindView(R.id.main_rb_joke)
    RadioButton mainRbJoke;
    @BindView(R.id.main_iv_video)
    ImageView mainIvVideo;
    @BindView(R.id.main_rb_video)
    RadioButton mainRbVideo;
    @BindView(R.id.main_rg)
    RadioGroup mainRg;
    private CommendFragment commendFragment;
    private JokesFragment jokesFragment;
    private VideoFragment videoFragment;
    private static final String TAG = "MainActivity";
    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //简单的绑定   使用控件
        ButterKnife.bind(this);
        //----
        titleView = new TitleView(MainActivity.this);
        titleView.setOnClickImage(this);
        //侧滑  slidingmenu
        slidingMenu();
    }

    private void slidingMenu() {
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        //TOUCHMODE_FULLSCREEN  设置滑动的屏幕范围，该设置为全屏区域都可以滑动
        //TOUCHMODE_MARGIN  从边缘滑出
        //TOUCHMODE_NONE   不能滑动
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.slidingmenu_offset);

        // 设置滑动 菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.shadow_width);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);

        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.layout_left_menu);
        //slidingmenu_head
        ImageView slidingmenu_head = findViewById(R.id.slidingmenu_head);
        slidingmenu_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                Toast.makeText(MainActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        //初始化fragment
        commendFragment = new CommendFragment();
        jokesFragment = new JokesFragment();
        videoFragment = new VideoFragment();
        //添加
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, commendFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, jokesFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, videoFragment).commit();
        //默认隐藏
        getSupportFragmentManager().beginTransaction().show(commendFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(jokesFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(videoFragment).commit();
        //默认显示推荐界面
//        setStyle(1);
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

    @OnClick({R.id.main_rb_commend, R.id.main_rb_joke, R.id.main_rb_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_rb_commend:
                getSupportFragmentManager().beginTransaction().show(commendFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(jokesFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(videoFragment).commit();
                setStyle(1);
                break;
            case R.id.main_rb_joke:
                getSupportFragmentManager().beginTransaction().hide(commendFragment).commit();
                getSupportFragmentManager().beginTransaction().show(jokesFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(videoFragment).commit();
                setStyle(2);
                break;
            case R.id.main_rb_video:
                getSupportFragmentManager().beginTransaction().hide(commendFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(jokesFragment).commit();
                getSupportFragmentManager().beginTransaction().show(videoFragment).commit();
                setStyle(3);
                break;
//            case R.id.main_rg:
//                break;
        }
    }

    private void setStyle(int flag) {
        //设置默认颜色
        mainRbCommend.setTextColor(Color.BLACK);
        mainRbJoke.setTextColor(Color.BLACK);
        mainRbVideo.setTextColor(Color.BLACK);
        //默认图片
        mainIvCommend.setImageResource(R.drawable.tuijian_normal);
        mainIvJokes.setImageResource(R.drawable.duanzi_normal);
        mainIvVideo.setImageResource(R.drawable.video_normal);
        //点击变成这个颜色
        int color = getResources().getColor(R.color.main_head);
        switch (flag) {
            case 1:
                //设置标题
                titleView.setHeadTitle("推荐");
                mainRbCommend.setTextColor(color);
                mainIvCommend.setImageResource(R.drawable.tuijian_select);
                break;
            case 2:
                //设置标题
                titleView.setHeadTitle("段子");
                mainRbJoke.setTextColor(color);
                mainIvJokes.setImageResource(R.drawable.duanzi_select);
//                Toast.makeText(this, "段子", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                //设置标题
                titleView.setHeadTitle("视频");
                mainRbVideo.setTextColor(color);
                mainIvVideo.setImageResource(R.drawable.video_select);

                break;
        }
    }

    @Override
    public void setSliding() {

    }

    //写信息
    @Override
    public void setWriteImage() {

    }
    //定义退出的标识
//    boolean flag = false;
}

package com.bwie.sj.onetime_sj.views.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.base.BaseAcrivity;
import com.bwie.sj.onetime_sj.views.fragment.CommendFragment;
import com.bwie.sj.onetime_sj.views.fragment.JokesFragment;
import com.bwie.sj.onetime_sj.views.fragment.VideoFragment;
import com.bwie.sj.slidingmenu.SlidingMenu;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseAcrivity {

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
    @BindView(R.id.title_head)
    ImageView titleHead;
    @BindView(R.id.title_write)
    ImageView titleWrite;
    @BindView(R.id.title_tv)
    TextView titleTv;
    private CommendFragment commendFragment;
    private JokesFragment jokesFragment;
    private VideoFragment videoFragment;
    private static final String TAG = "MainActivity";
    private SlidingMenu menu;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到sp
        sp = getSharedPreferences("userlogin", Activity.MODE_WORLD_READABLE);

        //简单的绑定   使用控件
        ButterKnife.bind(this);
        //侧滑  slidingmenu
        slidingMenu();

    }

    /**
     * 侧滑
     */
    private void slidingMenu() {
        menu = new SlidingMenu(this);
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
        SimpleDraweeView slidingmenu_head = findViewById(R.id.slidingmenu_head);
//        LinearLayout login_liner = findViewById(R.id.login_liner);
        LinearLayout guanzhu_liner = findViewById(R.id.guanzhu_liner);
        Button right_cancle = findViewById(R.id.right_cancle);
        //判断
        slidingmenu_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean flag = sp.getBoolean("flag", false);
                //如果为false表示没有登录过   所以跳到登录界面
                if (flag) {
                    //w为true表示登录过,跟换头像
                    Toast.makeText(MainActivity.this, "换头像啦===", Toast.LENGTH_SHORT).show();

                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }

            }
        });
        //跳关注
        guanzhu_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

            }
        });
        //==============================================
        right_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "aaaaa", Toast.LENGTH_LONG).show();
                File file = new File("/data/data/" + getPackageName().toString() + "/shared_prefs", "Activity.xml");
                if (file.exists()) {
                    file.delete();
                    Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(MainActivity.this, "ssss", Toast.LENGTH_LONG).show();

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

    @OnClick({R.id.main_rb_commend, R.id.main_rb_joke, R.id.main_rb_video, R.id.title_head, R.id.title_write})
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
            case R.id.title_head:
                //展示侧滑菜单
                menu.toggle(true);
                break;
            case R.id.title_write:
                boolean flag = sp.getBoolean("flag", false);
                //如果为false表示没有登录过   所以跳到登录界面
                if (flag) {
                    //跳转创作界面
                    startActivity(new Intent(MainActivity.this, CreatActivity.class));
                } else {
                    Toast.makeText(this, "亲,还没有登录呢 --", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
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
                titleTv.setText("推荐");
                mainRbCommend.setTextColor(color);
                mainIvCommend.setImageResource(R.drawable.tuijian_select);
                break;
            case 2:
                //设置标题
                titleTv.setText("段子");
                mainRbJoke.setTextColor(color);
                mainIvJokes.setImageResource(R.drawable.duanzi_select);
                break;
            case 3:
                //设置标题
                titleTv.setText("视频");
                mainRbVideo.setTextColor(color);
                mainIvVideo.setImageResource(R.drawable.video_select);
                break;
        }
    }


    //定义退出的标识
//    boolean flag = false;
}

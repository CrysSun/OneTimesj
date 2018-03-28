package com.bwie.sj.onetime_sj.views.viewself;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwie.sj.onetime_sj.R;

/**
 * 自定义控件    加号
 * https://blog.csdn.net/thw_m/article/details/79266815
 * Created by Administrator on 2018/03/26.
 */

public class JokeCicle extends RelativeLayout {
    private ImageView jok_comment;
    private ImageView jok_share;
    private ImageView jok_love;
    private ImageView jok_jian;
    private ImageView jok_jia;

    public JokeCicle(Context context) {
        super(context);
    }

    public JokeCicle(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.joke_cicle, this, false);
        jok_comment = view.findViewById(R.id.jok_comment);
        jok_share = view.findViewById(R.id.jok_share);
        jok_love = view.findViewById(R.id.jok_love);
        jok_jian = view.findViewById(R.id.jok_jian);
        jok_jia = view.findViewById(R.id.jok_jia);
        //=-
        jok_jia.setVisibility(View.VISIBLE);
        jok_jian.setVisibility(View.GONE);
        jok_comment.setVisibility(View.GONE);
        jok_share.setVisibility(View.GONE);
        jok_love.setVisibility(View.GONE);
        //点击加号   加号隐藏其他显示
        jok_jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                jok_jia.setVisibility(View.GONE);
                jok_jian.setVisibility(View.VISIBLE);
                jok_comment.setVisibility(View.VISIBLE);
                jok_share.setVisibility(View.VISIBLE);
                jok_love.setVisibility(View.VISIBLE);
                //展示动画
                showMenu();
            }
        });
        //点击减号   减号隐藏其他显示
        jok_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                jok_jia.setVisibility(View.VISIBLE);
                jok_jian.setVisibility(View.GONE);
                jok_comment.setVisibility(View.GONE);
                jok_share.setVisibility(View.GONE);
                jok_love.setVisibility(View.GONE);
                //隐藏动画
                hideMenu();
            }
        });
        //==========================
        addView(view);
    }
    public void hideMenu(){
        //三个平移回去
        ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(jok_comment
                , "translationX", jok_jia.getTranslationX(), 0);
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(jok_share
                , "translationX", jok_share.getTranslationX(), 0);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(jok_love
                , "translationX", jok_comment.getTranslationX(), 0);
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(jok_jia, "rotation", 0, 135, 0);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(jok_share, "rotation", 0, 180, 0);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(jok_comment, "rotation", 0, 180, 0);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(jok_love, "rotation", 0, 180, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(800);
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.playTogether(rotation1,rotation2,rotation3,rotation4,firstAnimator,secondAnimator,thirdAnimator);

        animatorSet.start();
    }
//    private void hideMenu() {
//        //平移展示
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(jok_comment
//                , "translationX", jok_share.getTranslationX(), 0);
//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(jok_share
//                , "translationX", jok_comment.getTranslationX(), 0);
//        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(jok_love
//                , "translationX", jok_comment.getTranslationX(), 0);
//        //旋转]
//        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(jok_jian, "rotation", 0, 135, 0);
//        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(jok_comment, "rotation", 0, 180, 0);
//        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(jok_share, "rotation", 0, 180, 0);
//        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(jok_love, "rotation", 0, 180, 0);
//        //动画集合
//        AnimatorSet animatorSet = new AnimatorSet();
//        //设置时间
//        animatorSet.setDuration(800);
//        animatorSet.playTogether(objectAnimator, objectAnimator1, objectAnimator2, rotation1, rotation2, rotation3, rotation4);
//        //开始
//        animatorSet.start();
//    }

    //展示按钮的动画
    private void showMenu() {
        //平移展示
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(jok_comment
                , "translationX", 0, -65 * 3);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(jok_share
                , "translationX", 0, -65 * 2);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(jok_love
                , "translationX", 0, -65 * 1);
        //旋转]
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(jok_jian, "rotation", 0, 135, 0);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(jok_comment, "rotation", 0, 180, 0);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(jok_share, "rotation", 0, 180, 0);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(jok_love, "rotation", 0, 180, 0);
        //动画集合
        AnimatorSet animatorSet = new AnimatorSet();
        //设置时间
        animatorSet.setDuration(800);
        animatorSet.playTogether(objectAnimator, objectAnimator1, objectAnimator2, rotation1, rotation2, rotation3, rotation4);
        //开始
        animatorSet.start();
    }

    public JokeCicle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

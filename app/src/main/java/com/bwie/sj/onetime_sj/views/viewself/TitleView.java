package com.bwie.sj.onetime_sj.views.viewself;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.sj.onetime_sj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bwie.sj.onetime_sj.R2.id.title_tv;

/**
 * 自定义标题view
 * Created by Administrator on 2018/03/13.
 */

public class TitleView extends RelativeLayout {
    ImageView title_iv;
    TextView title_tv;
    ImageView title_head;
    OnClickImage onClickImage;

    public TitleView(Context context) {
        this(context, null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.main_title, this, true);
        //可以不用做一些重复性的动作   findviewbyid
        ButterKnife.bind(this);
    }


    //图片的点击事件
    @OnClick({R.id.title_head, R.id.title_iv})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_head:
                //换头像
                onClickImage.setHeadIamge();
                break;
            case R.id.title_iv:
                //写信息
                onClickImage.setWriteImage();
                break;
        }
    }

    //改变tv的值
    public void setTitle(String title) {
        title_tv.setText(title);
    }

    //换头像的方法
    public void setTitleHead(Context context, String icon_url) {
        //-----------
        Glide.with(context).load(icon_url).into(title_head);
    }

    //定义外部访问
    public void setOnClickImage(OnClickImage onClickImage) {
        this.onClickImage = onClickImage;
    }

    //调用的接口
    public interface OnClickImage {
        void setHeadIamge();

        void setWriteImage();
    }
}

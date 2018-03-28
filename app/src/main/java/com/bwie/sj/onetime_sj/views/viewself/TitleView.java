package com.bwie.sj.onetime_sj.views.viewself;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.sj.onetime_sj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自定义标题view
 * Created by Administrator on 2018/03/13.
 */

public class TitleView extends RelativeLayout {

    @BindView(R.id.title_head)
    RoundImageView titleHead;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.title_write)
    ImageView titleWrite;
    private OnClickImage onClickImage;

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


    //改变tv的值  设置标题
    public void setHeadTitle(String title) {
        titleTv.setText(title);
    }

    //定义外部访问
    public void setOnClickImage(OnClickImage onClickImage) {
        this.onClickImage = onClickImage;
    }

    @OnClick({R.id.title_head, R.id.title_write})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_head:
                //展开  侧拉
                onClickImage.setSliding();
                break;
            case R.id.title_write:
                //写信息
                onClickImage.setWriteImage();
                break;
        }
    }

    //调用的接口
    public interface OnClickImage {
        void setSliding();

        void setWriteImage();
    }
}

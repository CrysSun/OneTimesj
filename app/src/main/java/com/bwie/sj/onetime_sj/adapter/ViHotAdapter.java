package com.bwie.sj.onetime_sj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.bean.ViHotBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2018/03/29.
 */

public class ViHotAdapter extends XRecyclerView.Adapter<ViHotAdapter.MyViewHolder> {
    Context context;
    List<ViHotBean.DataBean> list;

    public ViHotAdapter(Context context, List<ViHotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //视图
        View inflate = View.inflate(context, R.layout.vihot_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //赋值
        holder.vihot_item_icon.setUp(list.get(position).getVideoUrl(),list.get(position).getWorkDesc());
//        Glide.with(context).load(list.get(position).getCover()).into(holder.vihot_item_icon);
      holder.vihot_item_tv.setText(list.get(position).getCreateTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //viweholder
    class MyViewHolder extends RecyclerView.ViewHolder {
        private JCVideoPlayer vihot_item_icon;
        private TextView vihot_item_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.vihot_item_icon = itemView.findViewById(R.id.vihot_item_icon);
            this.vihot_item_tv = itemView.findViewById(R.id.vihot_item_tv);
        }

    }
}

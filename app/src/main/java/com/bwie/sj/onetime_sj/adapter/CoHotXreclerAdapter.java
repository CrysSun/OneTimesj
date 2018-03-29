package com.bwie.sj.onetime_sj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.bean.CoHotBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2018/03/23.
 */

public class CoHotXreclerAdapter extends XRecyclerView.Adapter<CoHotXreclerAdapter.ViewHolder> {
    Context context;
    List<CoHotBean.DataBean> list;

    public CoHotXreclerAdapter(Context context, List<CoHotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hot_xrecycler_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Glide.with(context).load(list.get(i).getUser().getIcon()).into(holder.recycler_tou);
        holder.recycler_name.setText(list.get(i).getUser().getNickname());
        holder.recycler_time.setText(list.get(i).getCreateTime());

        holder.recycler_title.setText(list.get(i).getWorkDesc());
//        Glide.with(context).load(list.get(i).getCover()).into(holder.recycler_icon);
        holder.recycler_user.setText(list.get(i).getUser().getNickname());
        holder.recycler_count.setText(list.get(i).getUser().getFans());
        holder.recycler_user2.setText(list.get(i).getUser().getNickname());
        holder.recycler_count2.setText(list.get(i).getUser().getFans());
        //视频  https://blog.csdn.net/qq_23477421/article/details/51822584
        holder.recycler_player.setUp(list.get(i).getVideoUrl(), list.get(i).getWorkDesc());
//        holder.recycler_player.ivThumb.setThumbInCustomProject("视频/MP3缩略图地址");
    }

    //
    @Override
    public int getItemCount() {
        return list.size();
    }


    //优化
    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView recycler_tou;
        private TextView recycler_name;
        private TextView recycler_time;
        private TextView recycler_title;
        private TextView recycler_user;
        private TextView recycler_count;
        private TextView recycler_user2;
        private TextView recycler_count2;
        private JCVideoPlayer recycler_player;

        public ViewHolder(View itemView) {
            super(itemView);
            this.recycler_tou = itemView.findViewById(R.id.recycler_tou);
            this.recycler_name = itemView.findViewById(R.id.recycler_name);
            this.recycler_time = itemView.findViewById(R.id.recycler_time);
            this.recycler_title = itemView.findViewById(R.id.recycler_title);
            this.recycler_user = itemView.findViewById(R.id.recycler_user);
            this.recycler_count = itemView.findViewById(R.id.recycler_count);
            this.recycler_user2 = itemView.findViewById(R.id.recycler_user2);
            this.recycler_count2 = itemView.findViewById(R.id.recycler_count2);
            this.recycler_player = itemView.findViewById(R.id.recycler_player);
        }

        public ImageView getRecycler_tou() {
            return recycler_tou;
        }

        public void setRecycler_tou(ImageView recycler_tou) {
            this.recycler_tou = recycler_tou;
        }

        public TextView getRecycler_name() {
            return recycler_name;
        }

        public void setRecycler_name(TextView recycler_name) {
            this.recycler_name = recycler_name;
        }

        public TextView getRecycler_time() {
            return recycler_time;
        }

        public void setRecycler_time(TextView recycler_time) {
            this.recycler_time = recycler_time;
        }

        public TextView getRecycler_title() {
            return recycler_title;
        }

        public void setRecycler_title(TextView recycler_title) {
            this.recycler_title = recycler_title;
        }

        public TextView getRecycler_user() {
            return recycler_user;
        }

        public void setRecycler_user(TextView recycler_user) {
            this.recycler_user = recycler_user;
        }

        public TextView getRecycler_count() {
            return recycler_count;
        }

        public void setRecycler_count(TextView recycler_count) {
            this.recycler_count = recycler_count;
        }

        public TextView getRecycler_user2() {
            return recycler_user2;
        }

        public void setRecycler_user2(TextView recycler_user2) {
            this.recycler_user2 = recycler_user2;
        }

        public TextView getRecycler_count2() {
            return recycler_count2;
        }

        public void setRecycler_count2(TextView recycler_count2) {
            this.recycler_count2 = recycler_count2;
        }

        public JCVideoPlayer getRecycler_player() {
            return recycler_player;
        }

        public void setRecycler_player(JCVideoPlayer recycler_player) {
            this.recycler_player = recycler_player;
        }
    }

}

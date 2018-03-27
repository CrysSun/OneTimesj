package com.bwie.sj.onetime_sj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2018/03/23.
 */

public class JokesXreclerAdapter extends XRecyclerView.Adapter<JokesXreclerAdapter.MyJokesViewholder> {
    Context context;
    List<JokeBean.DataBean> list;

    public JokesXreclerAdapter(Context context, List<JokeBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyJokesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.jokes_xrecycler_item, null);
        MyJokesViewholder myJokesViewholder = new MyJokesViewholder(view);
        return myJokesViewholder;
    }

    @Override
    public void onBindViewHolder(MyJokesViewholder holder, int i) {
        //为控件赋值
        Glide.with(context).load(list.get(i).getUser().getIcon()).into(holder.jokes_tou);
        holder.jokes_name.setText(list.get(i).getUser().getNickname());
        holder.jokes_time.setText(list.get(i).getCreateTime());

        holder.jokes_title.setText(list.get(i).getContent());
//        //点击事件
//        holder.jokes_jia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(context, "展示", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyJokesViewholder extends RecyclerView.ViewHolder {
        private ImageView jokes_tou;
        private TextView jokes_name;
        private TextView jokes_time;
//        private ImageView jokes_jia;
        private TextView jokes_title;

        public MyJokesViewholder(View itemView) {
            super(itemView);
            this.jokes_tou = itemView.findViewById(R.id.jokes_tou);
            this.jokes_name = itemView.findViewById(R.id.jokes_name);
            this.jokes_time = itemView.findViewById(R.id.jokes_time);
//            this.jokes_jia = itemView.findViewById(R.id.jokes_jia);
            this.jokes_title = itemView.findViewById(R.id.jokes_title);
        }

        public ImageView getJokes_tou() {
            return jokes_tou;
        }

        public void setJokes_tou(ImageView jokes_tou) {
            this.jokes_tou = jokes_tou;
        }

        public TextView getJokes_name() {
            return jokes_name;
        }

        public void setJokes_name(TextView jokes_name) {
            this.jokes_name = jokes_name;
        }

        public TextView getJokes_time() {
            return jokes_time;
        }

        public void setJokes_time(TextView jokes_time) {
            this.jokes_time = jokes_time;
        }

        public TextView getJokes_title() {
            return jokes_title;
        }

        public void setJokes_title(TextView jokes_title) {
            this.jokes_title = jokes_title;
        }
    }
}

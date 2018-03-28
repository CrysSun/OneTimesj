package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.adapter.JokesXreclerAdapter;
import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.model.JokeModelImpl;
import com.bwie.sj.onetime_sj.presenter.JokePresenterImpl;
import com.bwie.sj.onetime_sj.views.IJokeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.List;

/**
 * 段子的fragment
 * Created by Administrator on 2018/03/13.
 */

public class JokesFragment extends Fragment implements IJokeView {
    private static final String TAG = "JokesFragment";
    private XRecyclerView jokes_xrecler;
    private int page = 1;
    private JokePresenterImpl jokePresenter;
    private JokesXreclerAdapter jokesXreclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_jokes, null);
        jokes_xrecler = view.findViewById(R.id.jokes_xrecler);
        //初始化presenter
        jokePresenter = new JokePresenterImpl();
        getData(1);
        //上下拉刷新
        pull();
        return view;
    }

    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //初始化presenter
            jokePresenter = new JokePresenterImpl();
            getData(1);
        }
    }

    //上下拉刷新
    private void pull() {
        jokes_xrecler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getData(page);
                jokes_xrecler.refreshComplete();
                Toast.makeText(getActivity(), "下拉刷新" + page, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                page++;
                getData(page);
                jokes_xrecler.loadMoreComplete();
                Toast.makeText(getActivity(), "加载更多" + page, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //获取数据
    public void getData(int pages) {
        jokePresenter.showJokesToVIew(pages, new JokeModelImpl(), this);
    }

    @Override
    public void showJokes(List<JokeBean.DataBean> data) {
        Log.d(TAG, "showJokes: dddddddddddddddddddddddd" + data);
        if (jokesXreclerAdapter == null) {
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            jokes_xrecler.setLayoutManager(linearLayoutManager);
            //适配器
            jokesXreclerAdapter = new JokesXreclerAdapter(getActivity(), data);
            jokes_xrecler.setAdapter(jokesXreclerAdapter);

        } else {
            //刷新适配器
            jokesXreclerAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void showError(String json) {
        Toast.makeText(getActivity(), json, Toast.LENGTH_SHORT).show();
    }

    //解绑
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (jokePresenter != null) {
            jokePresenter.ondetach(this);
        }
    }
}

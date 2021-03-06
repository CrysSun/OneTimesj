package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.adapter.ViHotAdapter;
import com.bwie.sj.onetime_sj.bean.UserInfoBean;
import com.bwie.sj.onetime_sj.bean.ViHotBean;
import com.bwie.sj.onetime_sj.model.ViHotModelImpl;
import com.bwie.sj.onetime_sj.presenter.ViHotPresentImpl;
import com.bwie.sj.onetime_sj.views.IViHotView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by Administrator on 2018/03/24.
 */

public class ViHotFragment extends Fragment implements IViHotView {
    private static final String TAG = "ViHotFragment";

    private int page;
    private XRecyclerView vihot_xrecycler;
    private ViHotAdapter viHotAdapter;
    private ViHotPresentImpl viHotPresent;
    private String userToken;
    private List<ViHotBean.DataBean> listAll = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.video_hot, null);
        //注册eventbus
        EventBus.getDefault().register(this);

        vihot_xrecycler = view.findViewById(R.id.vihot_xrecycler);
        //上下拉
        pullXrecler();
        return view;
    }

    //接收eventbus传过来的值
    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
    public void onNewsEvent(UserInfoBean userInfoBean) {
        this.userToken = userInfoBean.getToken();
    }

    /**
     * 上下拉加载
     */
    private void pullXrecler() {
        vihot_xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                listAll.clear();
                getData(page);
                vihot_xrecycler.refreshComplete();
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                ++page;
                getData(page);
                vihot_xrecycler.loadMoreComplete();
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            page = 1;
            viHotPresent = new ViHotPresentImpl();
            getData(page);
        }
    }

    private void getData(int page) {
        viHotPresent.showViHotToView(userToken, page, new ViHotModelImpl(), this);
    }

    @Override
    public void showGrid(List<ViHotBean.DataBean> list) {
        listAll.addAll(list);
        Log.d(TAG, "showGrid: ============" + list);
        if (viHotAdapter == null) {
            //设置布局管理器
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            vihot_xrecycler.setLayoutManager(gridLayoutManager);
            //设置适配器
            viHotAdapter = new ViHotAdapter(getActivity(), list);
            vihot_xrecycler.setAdapter(viHotAdapter);
            Log.d(TAG, "showGrid: ============3333333333333333333333");
        } else {
            //刷新
            viHotAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), "???" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解绑eventbus
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}

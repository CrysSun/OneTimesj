package com.bwie.sj.onetime_sj.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.sj.onetime_sj.R;
import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.views.IJokeView;

import java.util.List;

/**
 * 段子的fragment
 * Created by Administrator on 2018/03/13.
 */

public class JokesFragment extends Fragment implements IJokeView {
    private static final String TAG = "JokesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_jokes, null);

        return view;
    }

    @Override
    public void showJokes(List<JokeBean.DataBean> data) {
        Log.d(TAG, "showJokes: dddddddddddddddddddddddd" + data);
        //适配器
    }

    @Override
    public void showError(String json) {
        Toast.makeText(getActivity(), json, Toast.LENGTH_SHORT).show();
    }
}

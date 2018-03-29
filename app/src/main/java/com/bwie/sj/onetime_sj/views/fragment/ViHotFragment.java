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
import com.bwie.sj.onetime_sj.bean.ViHotBean;
import com.bwie.sj.onetime_sj.views.IViHotView;

import java.util.List;

/**
 * Created by Administrator on 2018/03/24.
 */

public class ViHotFragment extends Fragment implements IViHotView {
    private static final String TAG = "ViHotFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.video_hot, null);

        return view;
    }

    @Override
    public void showGrid(List<ViHotBean.DataBean> data) {
        Log.d(TAG, "showGrid: ============" + data);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), "===" + error, Toast.LENGTH_SHORT).show();
    }
}

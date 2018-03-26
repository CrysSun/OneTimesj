package com.bwie.sj.onetime_sj.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwie.sj.onetime_sj.views.fragment.ViHotFragment;
import com.bwie.sj.onetime_sj.views.fragment.ViNearFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/03/24.
 */

public class CoHotTableAdapter extends FragmentPagerAdapter {
    List<String> list;
    Context context;

    public CoHotTableAdapter(FragmentManager fm, Context context, List<String> list) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ViHotFragment();
                break;
            case 1:
                fragment = new ViNearFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

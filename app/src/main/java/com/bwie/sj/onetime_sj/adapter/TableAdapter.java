package com.bwie.sj.onetime_sj.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwie.sj.onetime_sj.views.fragment.FollowFragment;
import com.bwie.sj.onetime_sj.views.fragment.HotFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/21.
 */

public class TableAdapter extends FragmentPagerAdapter {
    Context context;
    ArrayList<String> list;

    public TableAdapter(FragmentManager fm, Context context, ArrayList<String> list) {
        super(fm);
        this.context = context;
        this.list = list;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position);
    }

    public TableAdapter(FragmentManager fm, ArrayList<String> list, Context context) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HotFragment();
                break;
            case 1:
                fragment = new FollowFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

package com.example.wallace.wallacenews.yang.adapter;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private android.support.v4.app.FragmentManager fragmetnmanager;  //创建FragmentManager
    private List<android.support.v4.app.Fragment> listfragment; //创建一个List<Fragment>
    public MyFragmentPagerAdapter(android.support.v4.app.FragmentManager fm,List<android.support.v4.app.Fragment> list) {
        super( fm );
        this.fragmetnmanager =fm;
        this.listfragment =list;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return listfragment.get( position );
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
}

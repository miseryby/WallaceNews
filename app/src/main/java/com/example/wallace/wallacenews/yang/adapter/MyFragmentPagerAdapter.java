package com.example.wallace.wallacenews.yang.adapter;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wallace.wallacenews.R;
import com.viewpagerindicator.IconPagerAdapter;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter{
    private static final String[] CONTENT = new String[] { "头条", "社会", "国内", "国际" };
    private static final int[] ICONS = new int[] {
            R.mipmap.top,
            R.mipmap.social2,
            R.mipmap.china,
            R.mipmap.internation
    };
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
    public int getIconResId(int index) {
       return ICONS[index];
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return CONTENT[position % CONTENT.length].toUpperCase();
    }
}

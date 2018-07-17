package com.example.wallace.wallacenews.yang.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.yang.adapter.MyFragmentPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class NewsSortFragement extends android.support.v4.app.Fragment {
    private static final String[] TITLE = new String[] { "头条", "社会", "国内", "国际",
            "娱乐", "体育", "军事", "科技" ,"财经"};

    private android.support.v4.app.Fragment fm1,fm2,fm3,fm4,fm5;
    private List<android.support.v4.app.Fragment> listfragment =new ArrayList<>(  ); //创建一个List<Fragment>
    private MyFragmentPagerAdapter mAdapter;
    private ViewPager vp2;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );



    }
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_item,container,false );
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        listfragment.clear();
        addNewsSortFragment();

        mAdapter = new MyFragmentPagerAdapter( fragmentManager, listfragment );

        vp2 =(ViewPager) v.findViewById( R.id.vp2 );

        vp2.setAdapter( mAdapter );
        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
        indicator.setViewPager(vp2);
        return v;

    }
    private void addNewsSortFragment(){
        fm1 =new NewsListFragment(1);
        fm2 =new NewsListFragment(2);
        fm3 =new NewsListFragment(3);
        fm4 =new NewsListFragment(4);
        fm5 =new NewsListFragment(5);

        listfragment.add( fm1 );
        listfragment.add( fm2);
        listfragment.add( fm3);
        listfragment.add( fm4);

    }

}

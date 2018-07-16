package com.example.wallace.wallacenews.yang.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.yang.adapter.MyFragmentPagerAdapter;
import com.example.wallace.wallacenews.yang.ui.NewsListFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;


public abstract class SingleFragmentActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1, mRadioButton2, mRadioButton3;
    private static final String[] TITLE = new String[] { "头条", "房产", "另一面", "女人",
            "财经", "数码", "情感", "科技" };

    private List<android.support.v4.app.Fragment> listfragment =new ArrayList<>(  ); //创建一个List<Fragment>
    private MyFragmentPagerAdapter mAdapter;
    private CustomViewPager vp;
    private android.support.v4.app.Fragment fm1,fm2,fm3;
    protected abstract android.support.v4.app.Fragment creatFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_content );
        vp = (CustomViewPager) findViewById( R.id.vp );
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        fm1 =new NewsListFragment();
        fm2 =new DynamicListFragment();
        fm3 =new NewsMeFragment();
        listfragment.add( fm1);
        listfragment.add( fm2 );
        listfragment.add( fm3 );
        mAdapter = new MyFragmentPagerAdapter( fragmentManager, listfragment );

        vp.setAdapter( mAdapter );
        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(vp);
//        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.);
//        indicator.setViewPager(vp);
//        android.support.v4.app.Fragment fragment = fragmentManager.findFragmentById( R.id.fragment_container );
//        mRadioGroup = (RadioGroup) findViewById( R.id.rg );
//        mRadioButton1 = (RadioButton) findViewById( R.id.btn1 );
//        mRadioButton2 = (RadioButton) findViewById( R.id.btn2 );
//        mRadioButton3 = (RadioButton) findViewById( R.id.btn3 );
//        mRadioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == mRadioButton1.getId()) {
//                    Toast.makeText( SingleFragmentActivity.this, "你点击了首页", Toast.LENGTH_SHORT ).show();
//                    vp.setCurrentItem( 0,false );
//                }
//                if (checkedId == mRadioButton2.getId()) {
//
//                    vp.setCurrentItem( 1,false );
//
//                }
//                if (checkedId == mRadioButton3.getId()) {
//                    Toast.makeText( SingleFragmentActivity.this, "萨法", Toast.LENGTH_SHORT ).show();
//                    vp.setCurrentItem( 2,false );
//                }
//            }
//        } );

//        if(fragment ==null){
//
//            fragment = new NewsListFragment();
//            fragmentManager.beginTransaction().
//                    add( R.id.fragment_container,fragment )
//                    .commit();
//        }
//    }

    }

}

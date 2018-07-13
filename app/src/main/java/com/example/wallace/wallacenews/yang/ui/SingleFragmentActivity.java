package com.example.wallace.wallacenews.yang.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.wallace.wallacenews.R;
import com.example.wallace.wallacenews.yang.ui.NewsListFragment;


public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract android.support.v4.app.Fragment creatFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_content);
        android.support.v4.app.FragmentManager fragmentManager =getSupportFragmentManager();

        android.support.v4.app.Fragment fragment =fragmentManager.findFragmentById( R.id.fragment_container);
        if(fragment ==null){
            fragment = new NewsListFragment();
            fragmentManager.beginTransaction().
                    add( R.id.fragment_container,fragment )
                    .commit();
        }
    }
}

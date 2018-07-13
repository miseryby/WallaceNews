package com.example.wallace.wallacenews.yang.ui;

import android.app.Fragment;

public class NewsActivity extends SingleFragmentActivity {


    @Override
    protected android.support.v4.app.Fragment creatFragment() {
        return new NewsListFragment();
    }
}

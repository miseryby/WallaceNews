package com.example.wallace.wallacenews.yang.ui;

import android.support.v4.app.Fragment;

public class MeActivity extends  SingleFragmentActivity {
    @Override
    protected Fragment creatFragment() {
        return new NewsMeFragment();
    }
}

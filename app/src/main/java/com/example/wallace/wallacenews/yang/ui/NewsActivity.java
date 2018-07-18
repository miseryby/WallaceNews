package com.example.wallace.wallacenews.yang.ui;

import android.app.Fragment;
import android.view.View;
import android.widget.RadioButton;

public class NewsActivity extends SingleFragmentActivity {
    @Override
    protected android.support.v4.app.Fragment creatFragment() {
        return new NewsMeFragment();
    }


}

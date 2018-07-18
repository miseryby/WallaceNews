package com.example.wallace.wallacenews.yang.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wallace.wallacenews.R;

public class MeActivity extends  SingleFragmentActivity {


    @Override
    protected Fragment creatFragment() {
        return new NewsMeFragment();
    }


}

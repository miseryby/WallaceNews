package com.example.wallace.wallacenews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton mRadioButton1,mRadioButton2,mRadioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_content );
        mRadioButton1 =(RadioButton) findViewById( R.id.btn1 );
    }
}

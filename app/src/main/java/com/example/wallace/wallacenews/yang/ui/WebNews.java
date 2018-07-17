package com.example.wallace.wallacenews.yang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.wallace.wallacenews.R;

public class WebNews extends AppCompatActivity {
    private WebView mWebView;
    private TextView mTextView;
    private Button mButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        Intent intent =getIntent();
        setContentView( R.layout.activity_news_web );
//        mTextView =(TextView) findViewById( R.id.text_web );
//        mTextView.setText(intent.getStringExtra("nv_name"));

        mWebView =(WebView) findViewById( R.id.new_web );
        mWebView.loadUrl(intent.getStringExtra( "URL" ));
        mButton =(Button)findViewById( R.id.web_back_btn );
        mButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(WebNews.this,NewsActivity.class);
                startActivity( intent );
            }
        } );
    }
}

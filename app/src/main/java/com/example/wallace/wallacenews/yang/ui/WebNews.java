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
import com.example.wallace.wallacenews.peng.beans.Data;
import com.example.wallace.wallacenews.yang.test.News;
import com.example.wallace.wallacenews.yang.util.NewsCache;
import com.example.wallace.wallacenews.yang.util.SerializeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebNews extends AppCompatActivity {
    private WebView mWebView;
    private TextView mTextView;
    private Button mButton;
    private Button mButton1;
    private List<Data> mCList=new ArrayList<>();
    private final static String title ="NEWSC";
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
        final Data news = (Data) intent.getSerializableExtra( "NEWS" );
        mButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(WebNews.this,NewsActivity.class);
                startActivity( intent );
            }
        } );
        mButton1 =(Button)findViewById( R.id.web_col_btn );
        mButton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsCache cache = new NewsCache(getApplicationContext());
                mCList.add( news );
                String s = null;
                try {
                    s = SerializeUtils.serialize(mCList);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (cache.checkByKey("F"+title)) {

                    cache.updateValue("F"+title, s);
                }
                else {
                    cache.insert("F"+title, s);
                }
            }
        } );
    }
}

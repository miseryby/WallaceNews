package com.example.wallace.wallacenews.yan.DAO;

import android.content.Context;

import com.example.wallace.wallacenews.yan.JavaBean.NewsInfo;

import cn.bmob.v3.Bmob;

public class NewsInfoDAO {
    private NewsInfo ni = new NewsInfo();

    //数据库连接
    public void connectDB(Context context){
        //第一：默认初始化
        Bmob.initialize(context, "5eac7e65d8080c23fff499ea10d54d93");
    }
    
}

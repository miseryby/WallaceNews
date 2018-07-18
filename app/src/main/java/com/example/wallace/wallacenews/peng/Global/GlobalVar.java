package com.example.wallace.wallacenews.peng.Global;

import android.app.Application;

import com.example.wallace.wallacenews.yan.JavaBean.UserInfo;

/**
 * Created by whs on 17/5/1.
 */

public class GlobalVar extends Application {
    public static boolean loginStatus;
    public static UserInfo nowUser;

    public UserInfo getNowUser() {
        return nowUser;
    }

    public void setNowUser(UserInfo nowUser) {
        this.nowUser = nowUser;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setLoginStatus(false);
        //如果缓存文件存在，就从缓存中加载用户数据

    }
    public boolean getLoginStatus() {//调用此函数可以获得name的值.
        return loginStatus;
    }
    public void setLoginStatus(boolean status) {//调用此函数可以改变name的值，name是一个字符串类型的数据.
        this.loginStatus = status;
    }
}
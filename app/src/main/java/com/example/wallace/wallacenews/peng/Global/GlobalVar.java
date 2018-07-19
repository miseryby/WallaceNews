package com.example.wallace.wallacenews.peng.Global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.wallace.wallacenews.yan.DAO.UserInfoDAO;
import com.example.wallace.wallacenews.yan.JavaBean.HotInfo;
import com.example.wallace.wallacenews.yan.JavaBean.UserInfo;

import java.util.List;
import java.util.logging.LogRecord;

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

    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        setLoginStatus(false);
        handler = new Handler(){
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    nowUser = (UserInfo) msg.obj;
                    setLoginStatus(true);
                    Toast.makeText(GlobalVar.this, "你好，"+nowUser.getUserName(), Toast.LENGTH_SHORT).show();
                } else if (msg.what == 0){
                    Toast.makeText(GlobalVar.this, "用户默认登录不ok，请手动登录", Toast.LENGTH_SHORT).show();
                }
            }
        };
        UserInfoDAO.findUser("12345678",GlobalVar.this,handler);
        //如果缓存文件存在，就从缓存中加载用户数据
    }
    public boolean getLoginStatus() {//调用此函数可以获得name的值.
    return loginStatus;
}
    public void setLoginStatus(boolean status) {//调用此函数可以改变name的值，name是一个字符串类型的数据.
        this.loginStatus = status;
    }
}
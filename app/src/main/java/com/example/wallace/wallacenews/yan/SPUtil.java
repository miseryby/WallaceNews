package com.example.wallace.wallacenews.yan;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.wallace.wallacenews.yan.JavaBean.UserInfo;


public class SPUtil {

    //使用SharedPreferences存储数据
    public static  void saveData(Context context,String name,String key,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }

    //从SharedPreferences里面读取数据
    public static String lodaData(Context context,String name,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"其值为");
    }

    //这个方法是保存已经登录的用户的用户信息，以便可以方便业务操作
    public static void saveUser(Context context, UserInfo userInfo){
        saveData(context,"user","UserId",userInfo.getUserId());
        saveData(context,"user","UserPwd",userInfo.getUserPwd());
        saveData(context,"user","UserName",userInfo.getUserName());
        saveData(context,"user","UserSex",userInfo.getUserSex());
        saveData(context,"user","UserPhone",userInfo.getUserPhone());
    }
}

package com.example.wallace.wallacenews.yan.JavaBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class UserInfo extends BmobObject {
    //用户的信息
    private String UserId;      //用户ID
    private String UserPwd;     //用户密码
    private String UserName;    //用户昵称
    private String UserSex;     //用户性别
    private String UserPhone;   //用户的绑定手机
    private boolean EmailVerified = false; //邮箱激活状态
    private String Email;       //用户邮箱
    private BmobFile  Icon;      //用户头像

    public UserInfo() {

    }

    public UserInfo(String userId, String userPwd, String userName, String userSex, String userPhone, boolean emailVerified, String email) {
        UserId = userId;
        UserPwd = userPwd;
        UserName = userName;
        UserSex = userSex;
        UserPhone = userPhone;
        EmailVerified = emailVerified;
        Email = email;
    }

    public UserInfo(String tableName, String userId, String userPwd, String userName, String userSex, String userPhone, boolean emailVerified, String email) {
        super(tableName);
        UserId = userId;
        UserPwd = userPwd;
        UserName = userName;
        UserSex = userSex;
        UserPhone = userPhone;
        EmailVerified = emailVerified;
        Email = email;
    }

    public BmobFile getIcon() {
        return Icon;
    }

    public void setIcon(BmobFile icon) {
        Icon = icon;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public boolean isEmailVerified() {
        return EmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        EmailVerified = emailVerified;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

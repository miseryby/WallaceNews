package com.example.wallace.wallacenews.yan.JavaBean;

import cn.bmob.v3.BmobObject;

/**
 * Created by nie on 2018/7/15.
 */

public class Users extends BmobObject {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password= password;
    }

}

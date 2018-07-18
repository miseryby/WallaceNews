package com.example.wallace.wallacenews.yan.JavaBean;

import java.util.Date;

import cn.bmob.v3.BmobObject;

public class Subscribe extends BmobObject {
    //用户对新闻栏目的订阅
    private String UserId;      //用户ID
    private String NewsTypeId;  //新闻所属类型ID
    private String NewsTypeName;//新闻所属类型名字
    private Date SubscribeDate; //订阅时间

    public Subscribe() {
    }

    public Subscribe(String userId, String newsTypeId, String newsTypeName, Date subscribeDate) {
        UserId = userId;
        NewsTypeId = newsTypeId;
        NewsTypeName = newsTypeName;
        SubscribeDate = subscribeDate;
    }

    public Subscribe(String tableName, String userId, String newsTypeId, String newsTypeName, Date subscribeDate) {
        super(tableName);
        UserId = userId;
        NewsTypeId = newsTypeId;
        NewsTypeName = newsTypeName;
        SubscribeDate = subscribeDate;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getNewsTypeId() {
        return NewsTypeId;
    }

    public void setNewsTypeId(String newsTypeId) {
        NewsTypeId = newsTypeId;
    }

    public String getNewsTypeName() {
        return NewsTypeName;
    }

    public void setNewsTypeName(String newsTypeName) {
        NewsTypeName = newsTypeName;
    }

    public Date getSubscribeDate() {
        return SubscribeDate;
    }

    public void setSubscribeDate(Date subscribeDate) {
        SubscribeDate = subscribeDate;
    }
}

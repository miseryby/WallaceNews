package com.example.wallace.wallacenews.yan.JavaBean;

import java.util.Date;

import cn.bmob.v3.BmobObject;

public class Keep extends BmobObject {

    //收藏
    private String UserId;  //用户ID
    private String NewsId;  //新闻的ID
    private Date KeepDate;    //收藏时间
    private String NewsURL;       //新闻来源地址

    public Keep() {
    }

    public Keep(String userId, String newsId, Date keepDate, String newsURL) {
        UserId = userId;
        NewsId = newsId;
        KeepDate = keepDate;
        NewsURL = newsURL;
    }

    public Keep(String tableName, String userId, String newsId, Date keepDate, String newsURL) {
        super(tableName);
        UserId = userId;
        NewsId = newsId;
        KeepDate = keepDate;
        NewsURL = newsURL;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String newsId) {
        NewsId = newsId;
    }

    public Date getKeepDate() {
        return KeepDate;
    }

    public void setKeepDate(Date keepDate) {
        KeepDate = keepDate;
    }

    public String getNewsURL() {
        return NewsURL;
    }

    public void setNewsURL(String newsURL) {
        NewsURL = newsURL;
    }
}

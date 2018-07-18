package com.example.wallace.wallacenews.yan.JavaBean;

import java.util.Date;

import cn.bmob.v3.BmobObject;

public class NewsVisit extends BmobObject {
    //此处的浏览对应的是用户对一则新闻的浏览
    //而LiuLan记录的是对应的用户对新闻类别的浏览，好让新闻app推送相应的新闻给用户
    private String UserId;
    private String NewsId;
    private Date LastVisitDate;//用户对这则新闻的上次浏览时间
    private int  VisitNum;      //用户对这则新闻浏览了多少次；

    public NewsVisit() {
    }

    public NewsVisit(String userId, String newsId, Date lastVisitDate, int visitNum) {
        UserId = userId;
        NewsId = newsId;
        LastVisitDate = lastVisitDate;
        VisitNum = visitNum;
    }

    public NewsVisit(String tableName, String userId, String newsId, Date lastVisitDate, int visitNum) {
        super(tableName);
        UserId = userId;
        NewsId = newsId;
        LastVisitDate = lastVisitDate;
        VisitNum = visitNum;
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

    public Date getLastVisitDate() {
        return LastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        LastVisitDate = lastVisitDate;
    }

    public int getVisitNum() {
        return VisitNum;
    }

    public void setVisitNum(int visitNum) {
        VisitNum = visitNum;
    }
}

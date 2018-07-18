package com.example.wallace.wallacenews.yan.JavaBean;

import java.util.Date;

import cn.bmob.v3.BmobObject;

public class Search extends BmobObject {

    private String UserId;
    private String NewsTypeId;      //所属类型编号
    private String NewsTypeName;    //新闻类型
    private Date LastSearchDate;    //最近浏览时间
    private int    SearchNum;       //用户对这种类型的新闻浏览次数

    public Search() {
    }

    public Search(String userId, String newsTypeId, String newsTypeName, Date lastSearchDate, int searchNum) {
        UserId = userId;
        NewsTypeId = newsTypeId;
        NewsTypeName = newsTypeName;
        LastSearchDate = lastSearchDate;
        SearchNum = searchNum;
    }

    public Search(String tableName, String userId, String newsTypeId, String newsTypeName, Date lastSearchDate, int searchNum) {
        super(tableName);
        UserId = userId;
        NewsTypeId = newsTypeId;
        NewsTypeName = newsTypeName;
        LastSearchDate = lastSearchDate;
        SearchNum = searchNum;
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

    public Date getLastSearchDate() {
        return LastSearchDate;
    }

    public void setLastSearchDate(Date lastSearchDate) {
        LastSearchDate = lastSearchDate;
    }

    public int getSearchNum() {
        return SearchNum;
    }

    public void setSearchNum(int searchNum) {
        SearchNum = searchNum;
    }
}

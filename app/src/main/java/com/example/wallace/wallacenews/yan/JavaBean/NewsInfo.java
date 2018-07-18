package com.example.wallace.wallacenews.yan.JavaBean;

import cn.bmob.v3.BmobObject;

public class NewsInfo extends BmobObject {
    //一条新闻所包含的所有信息，此处不保存内容
    private String NewsId;      //新闻唯一编号
    private String NewsTitle;   //新闻标题
    private String NewsDate;    //出版 日期
    private String NewsAuthor;  //新闻作者
    private String NewsURL;     //新闻来源地址
    private String NewsImg;     //图片
    private String NewsType;    //所属类别
    private String NewsTypeId;  //所属类别的ID

    public NewsInfo() {
    }

    public NewsInfo(String newsId, String newsTitle, String newsDate, String newsAuthor, String newsURL, String newsImg, String newsType, String newsTypeId) {
        NewsId = newsId;
        NewsTitle = newsTitle;
        NewsDate = newsDate;
        NewsAuthor = newsAuthor;
        NewsURL = newsURL;
        NewsImg = newsImg;
        NewsType = newsType;
        NewsTypeId = newsTypeId;
    }

    public NewsInfo(String tableName, String newsId, String newsTitle, String newsDate, String newsAuthor, String newsURL, String newsImg, String newsType, String newsTypeId) {
        super(tableName);
        NewsId = newsId;
        NewsTitle = newsTitle;
        NewsDate = newsDate;
        NewsAuthor = newsAuthor;
        NewsURL = newsURL;
        NewsImg = newsImg;
        NewsType = newsType;
        NewsTypeId = newsTypeId;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String newsId) {
        NewsId = newsId;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsDate() {
        return NewsDate;
    }

    public void setNewsDate(String newsDate) {
        NewsDate = newsDate;
    }

    public String getNewsAuthor() {
        return NewsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        NewsAuthor = newsAuthor;
    }

    public String getNewsURL() {
        return NewsURL;
    }

    public void setNewsURL(String newsURL) {
        NewsURL = newsURL;
    }

    public String getNewsImg() {
        return NewsImg;
    }

    public void setNewsImg(String newsImg) {
        NewsImg = newsImg;
    }

    public String getNewsType() {
        return NewsType;
    }

    public void setNewsType(String newsType) {
        NewsType = newsType;
    }

    public String getNewsTypeId() {
        return NewsTypeId;
    }

    public void setNewsTypeId(String newsTypeId) {
        NewsTypeId = newsTypeId;
    }
}

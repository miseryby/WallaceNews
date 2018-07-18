package com.example.wallace.wallacenews.yan.JavaBean;

import java.util.Date;

import cn.bmob.v3.BmobObject;

public class NewsComment extends BmobObject {
    //此处对应的是用户对一则新闻的评论信息
    private String UserId;
    private String NewsId;
    private Date NewsCommentDate;           //评论时间
    private int  NewsCommentLikeNum;      //对这则新闻的点赞数
    private String NewsComment;         //评论内容

    public NewsComment() {
    }

    public NewsComment(String userId, String newsId, Date newsCommentDate, int newsCommentLikeNum, String newsComment) {
        UserId = userId;
        NewsId = newsId;
        NewsCommentDate = newsCommentDate;
        NewsCommentLikeNum = newsCommentLikeNum;
        NewsComment = newsComment;
    }

    public NewsComment(String tableName, String userId, String newsId, Date newsCommentDate, int newsCommentLikeNum, String newsComment) {
        super(tableName);
        UserId = userId;
        NewsId = newsId;
        NewsCommentDate = newsCommentDate;
        NewsCommentLikeNum = newsCommentLikeNum;
        NewsComment = newsComment;
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

    public Date getNewsCommentDate() {
        return NewsCommentDate;
    }

    public void setNewsCommentDate(Date newsCommentDate) {
        NewsCommentDate = newsCommentDate;
    }

    public int getNewsCommentLikeNum() {
        return NewsCommentLikeNum;
    }

    public void setNewsCommentLikeNum(int newsCommentLikeNum) {
        NewsCommentLikeNum = newsCommentLikeNum;
    }

    public String getNewsComment() {
        return NewsComment;
    }

    public void setNewsComment(String newsComment) {
        NewsComment = newsComment;
    }
}

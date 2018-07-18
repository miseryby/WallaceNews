package com.example.wallace.wallacenews.yan.JavaBean;

import java.util.Date;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class HotInfo extends BmobObject {
    private Integer HotId;   //头条ID
    private String UserId;      //用户ID

    public String getUserName() {
        return UserName;
    }

    private String UserName;

    public BmobFile getUserIcon() {
        return UserIcon;
    }

    public void setUserIcon(BmobFile userIcon) {
        UserIcon = userIcon;
    }

    private BmobFile UserIcon;
    private String Hot;         //头条内容
    private Date HotDate;//出版时间
    private Integer HotCommentNum; //评论数
    private Integer HotLikeNum;    //点赞数
    private Integer HotTransNum; //转发数

    public BmobFile getHotIcon() {
        return HotIcon;
    }

    public void setHotIcon(BmobFile hotIcon) {
        HotIcon = hotIcon;
    }

    private BmobFile HotIcon;

    public HotInfo() {
    }

    public HotInfo(Integer hotId, String userId, String hot, Date hotDate, int hotCommentNum, int hotLikeNum, int hotTransNum) {
        HotId = hotId;
        UserId = userId;
        Hot = hot;
        HotDate = hotDate;
        HotCommentNum = hotCommentNum;
        HotLikeNum = hotLikeNum;
        HotTransNum = hotTransNum;
    }

    public HotInfo(String tableName, Integer hotId, String userId, String hot, Date hotDate, int hotCommentNum, int hotLikeNum, int hotTransNum) {
        super(tableName);
        HotId = hotId;
        UserId = userId;
        Hot = hot;
        HotDate = hotDate;
        HotCommentNum = hotCommentNum;
        HotLikeNum = hotLikeNum;
        HotTransNum = hotTransNum;
    }

    public Integer getHotId() {
        return HotId;
    }

    public void setHotId(Integer hotId) {
        HotId = hotId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getHot() {
        return Hot;
    }

    public void setHot(String hot) {
        Hot = hot;
    }

    public Date getHotDate() {
        return HotDate;
    }

    public void setHotDate(Date hotDate) {
        HotDate = hotDate;
    }

    public int getHotCommentNum() {
        return HotCommentNum;
    }

    public void setHotCommentNum(int hotCommentNum) {
        HotCommentNum = hotCommentNum;
    }

    public int getHotLikeNum() {
        return HotLikeNum;
    }

    public void setHotLikeNum(int hotLikeNum) {
        HotLikeNum = hotLikeNum;
    }

    public int getHotTransNum() {
        return HotTransNum;
    }

    public void setHotTransNum(int hotTransNum) {
        HotTransNum = hotTransNum;
    }
}

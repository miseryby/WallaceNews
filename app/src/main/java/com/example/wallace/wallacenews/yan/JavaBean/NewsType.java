package com.example.wallace.wallacenews.yan.JavaBean;

import cn.bmob.v3.BmobObject;

public class NewsType extends BmobObject {
    //判定一条新闻他是什么类型的，军事/财经/政治/娱乐/体育等
    private String NewsTypeId;  //所属类型编号
    private String NewsTypeName;//所属类型名

    public NewsType() {
    }

    public NewsType(String newsTypeId, String newsTypeName) {
        NewsTypeId = newsTypeId;
        NewsTypeName = newsTypeName;
    }

    public NewsType(String tableName, String newsTypeId, String newsTypeName) {
        super(tableName);
        NewsTypeId = newsTypeId;
        NewsTypeName = newsTypeName;
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
}

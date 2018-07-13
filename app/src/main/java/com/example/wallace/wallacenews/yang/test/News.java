package com.example.wallace.wallacenews.yang.test;

import java.util.Date;
import java.util.UUID;

public class News {
    private UUID mUUID;
    String title;
    String detail;
    Date mDate;

    public News() {
        mUUID = UUID.randomUUID();
        mDate = new Date(  );
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}

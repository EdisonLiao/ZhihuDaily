package com.example.edisonliao.zhihudaily.entity;

/**
 * Created by edisonliao on 2018/2/7.
 */

public class NewsItemData {

    private String imgUrl;
    private String txt;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}

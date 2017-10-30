package com.bawei.beans;

/**
 * Created by Administrator on 2017/9/22.
 */
public class Newslist {
    private String ctime;
    private String description;
    private String picUrl;
    private String title;
    private String url;

    public Newslist(String ctime, String description, String picUrl, String title, String url) {
        this.ctime = ctime;
        this.description = description;
        this.picUrl = picUrl;
        this.title = title;
        this.url = url;
    }

    public String getCtime() {
        return ctime;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

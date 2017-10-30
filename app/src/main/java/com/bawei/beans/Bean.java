package com.bawei.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class Bean {
    private int code;
    private String msg;
    private List<Newslist> newslist;

    public Bean(int code, String msg, List<Newslist> newslist) {
        this.code = code;
        this.msg = msg;
        this.newslist = newslist;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<Newslist> getNewslist() {
        return newslist;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setNewslist(List<Newslist> newslist) {
        this.newslist = newslist;
    }
}

package com.example.zee.Models;

import java.util.ArrayList;

public class ListPosts {
    private String msg;

    private String pageCount;

    private String postsCount;

    private ArrayList<PostsList> list;

    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(String postsCount) {
        this.postsCount = postsCount;
    }

    public ArrayList<PostsList> getPostsList() {
        return list;
    }

    public void setPostsList(ArrayList<PostsList> PostsList) {
        this.list = PostsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassPojo [msg = " + msg + ", pageCount = " + pageCount + ", postsCount = " + postsCount + ", PostsList = " + list + ", status = " + status + "]";
    }
}
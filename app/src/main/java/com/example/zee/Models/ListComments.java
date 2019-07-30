package com.example.zee.Models;

import java.util.ArrayList;

public class ListComments {
    private String msg;

    private String pageCount;

    private ArrayList<ResponseList> list;

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

    public ArrayList<ResponseList> getList() {
        return list;
    }

    public void setList(ArrayList<ResponseList> list) {
        this.list = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassPojo [msg = " + msg + ", pageCount = " + pageCount + ", list = " + list + ", status = " + status + "]";
    }
}


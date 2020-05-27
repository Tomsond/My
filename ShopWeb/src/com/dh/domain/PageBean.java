package com.dh.domain;

import java.util.ArrayList;
import java.util.List;


public class PageBean<T> {
    private int totalPage; //总页数
    private int totalCount; //总记录数

    private int currentPage;//当前页

    private int pageSize;   //每页显示条数
    private List<T> list=new ArrayList<>();      //商品列表

    public PageBean(int totalCount, int currentPage, int pageSize) {
        //计算总页数
        if(totalCount%pageSize == 0) {
            this.totalPage = totalCount/pageSize;
        }else{
            this.totalPage=totalCount/pageSize+1;
        }

        this.totalCount = totalCount;
        this.currentPage=currentPage;
        this.pageSize = pageSize;
    }

    //为limit语句，提供起始索引

    public int getStart(){
        return (this.currentPage-1)*this.pageSize;
    }

    //set/get
    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

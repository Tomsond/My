package com.dh.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象
 */
public class PageBean<T> {
    private int totalPage;
    private int totalCount;
    private int currentPage;
    private int pageSize;
    private List<T> pageList=new ArrayList<>();

    //初始化参数
    public PageBean(int totalCount, int currentPage, int pageSize) {
        //计算总页数
        if(totalCount % pageSize ==0){
            this.totalPage=totalCount/pageSize;
        }else{
            this.totalPage=totalCount/pageSize+1;
        }

        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    //提供limit语句的初始索引
    public int getStart(){
        return (this.currentPage-1)*this.pageSize;
    }

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

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}

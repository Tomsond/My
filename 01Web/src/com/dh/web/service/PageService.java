package com.dh.web.service;

import com.dh.dao.PageDao;
import com.dh.domain.PageBean;
import com.dh.domain.Student;

import java.sql.SQLException;
import java.util.List;

public class PageService {
    //构建PageBean对象
    public PageBean<Student> findPageBean(int currentPage, int pageSize) throws SQLException {
        PageDao dao=new PageDao();

        //获取totalCount
        int totalCount=dao.getTotalCount();
        PageBean pageBean=new PageBean(currentPage,pageSize,totalCount);
        //获得pageList
        List<Student> pageList=dao.getList(pageBean.getStart(),pageSize);
        pageBean.setPageList(pageList);
        return pageBean;
    }
}

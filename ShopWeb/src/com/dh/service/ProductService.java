package com.dh.service;

import com.dh.dao.ProductDao;
import com.dh.domain.PageBean;
import com.dh.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public List<Product> findAllProduct() throws SQLException {
        ProductDao dao=new ProductDao();
        return dao.findAllProduct();
    }

    public PageBean<Product> findPageBean(int currentPage, int pageSize) throws SQLException {
        ProductDao dao=new ProductDao();

        //构建PageBean
        //计算总页数
        int totalCount=dao.getTotalCount();
        PageBean pageBean=new PageBean(totalCount, currentPage, pageSize);
        //获得list
        List<Product> list=dao.getList(pageBean.getStart(),pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}

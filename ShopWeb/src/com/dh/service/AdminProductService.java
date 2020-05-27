package com.dh.service;

import com.dh.dao.AdminProductDao;
import com.dh.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class AdminProductService {

    //查询所有商品
    public List<Product> findAllProduct() throws SQLException {
        AdminProductDao dao=new AdminProductDao();
        return dao.findAllProduct();
    }
}

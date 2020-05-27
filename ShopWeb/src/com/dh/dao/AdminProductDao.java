package com.dh.dao;

import com.dh.domain.Product;
import com.dh.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminProductDao {

    public List<Product> findAllProduct() throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product";
        List<Product> productList=qr.query(sql, new BeanListHandler<Product>(Product.class));
        return productList;
    }
}

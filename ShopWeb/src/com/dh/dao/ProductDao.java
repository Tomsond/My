package com.dh.dao;

import com.dh.domain.Product;
import com.dh.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {

    public List<Product> findAllProduct() throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product";
        return qr.query(sql, new BeanListHandler<Product>(Product.class));
    }

    //获得总记录数
    public int getTotalCount() throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from product";
        Long query = (Long) qr.query(sql, new ScalarHandler());
        return query.intValue();
    }

    //limit查的记录
    public List<Product> getList(int start,int pageSize) throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product limit ?,?";
        return qr.query(sql, new BeanListHandler<Product>(Product.class),start,pageSize);
    }
}

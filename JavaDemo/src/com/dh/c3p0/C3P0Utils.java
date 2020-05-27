package com.dh.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0工具类
 */
public class C3P0Utils {
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    //获得dataSource
    public static DataSource getDataSource(){
        return dataSource;
    }

    //获得连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

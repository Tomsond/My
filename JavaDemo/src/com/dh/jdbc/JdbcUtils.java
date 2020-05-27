package com.dh.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类
 */
public class JdbcUtils {
    //提升作用域
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    /**
     * 静态代码块加载配置文件
     */
    static {
        try {
            InputStream is =JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties props=new Properties();
            props.load(is);
            //获取文件的参数
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *获得连接
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放连接
     */
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

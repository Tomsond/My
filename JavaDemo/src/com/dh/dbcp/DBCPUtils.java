package com.dh.dbcp;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * dbcp连接池
 */
public class DBCPUtils {
    private static DataSource dataSource;

    static{
        try {
            InputStream is =DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties props=new Properties();
            props.load(is);
            dataSource=BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    /**
     * 获取数据源
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取conn
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

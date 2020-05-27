package com.dh.c3p0;

import com.dh.jdbc.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试c3p0连接池
 */
public class Testc3p0 {
    Connection conn=null;
    PreparedStatement pstmt=null;
    @Test
    public void test(){
        ComboPooledDataSource dataSource=new ComboPooledDataSource(); //加载c3p0中默认的配置
        //ComboPooledDataSource dataSource=new ComboPooledDataSource("oracle"); //加载c3p0中有名字的配置
        try {
            conn = JdbcUtils.getConnection();
            String sql="insert into stu values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,3);
            pstmt.setString(2,"Rose");
            pstmt.setInt(3,23);
            int row = pstmt.executeUpdate();
            if(row >0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,pstmt,null);
        }
    }
}

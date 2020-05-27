package com.dh.jdbc;

import java.sql.*;

/**
 * Jdbc连接数据库
 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","123");
        //3.获得stmt，执行sql语句
        //Statement stmt =con.createStatement();//
        //String sql="select * from stu where id=1";
        String sql="update stu set name=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,"Tom");
        pstmt.setInt(2,2);
        //ResultSet rs = stmt.executeQuery(sql);
        int row = pstmt.executeUpdate(); //影响的行数
        //4.获取结果集--》查询
//        while(rs.next()){
////            System.out.println("id: "+rs.getInt(1)+"name: "+rs.getString("name")+"age: "+rs.getInt("age"));
////        }
        if(row>0){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
        //关闭
        //rs.close();
        pstmt.close();//stmt.close();
        con.close();
    }
}

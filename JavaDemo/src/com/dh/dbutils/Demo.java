package com.dh.dbutils;

import com.dh.c3p0.C3P0Utils;
import com.dh.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * DBUtils
 */
public class Demo {

    //qr的增删改操作
    @Test
    public void test1() {
        try {
            //1.获得qr核心对象
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.执行sql语句
            String sql = "insert into stu values(?,?,?)";
            Object[] params = {4, "周杰伦", 25};
            int row = qr.update(sql, params);
            if (row > 0) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //qr的查询操作:所有BeanListHandler
    @Test
    public void test2(){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="select * from stu";
            //返回的是个beanlist结果集
            List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
            //遍历users
            for (User user:users) {
                System.out.println(user.getId()+" : "+user.getName()+" : "+user.getAge());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //qr的查询操作:ID查询BeanHandler
    @Test
    public void test3(){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="select * from stu where id=?";
            Object[] params={1};
            //返回的是个bean
            User user= qr.query(sql, new BeanHandler<User>(User.class),params);
            System.out.println(user.getId()+" : "+user.getName()+" : "+user.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //qr的查询操作:总个数ScalarHandler
    @Test
    public void test4(){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="select count(*) from stu";
            //返回的是Long
            Long count= (Long) qr.query(sql, new ScalarHandler());
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //qr的查询操作:MapListHandler、MapHandler
    @Test
    public void test5(){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="select * from stu";
            //返回的是Long
            List<Map<String, Object>> maps = qr.query(sql, new MapListHandler());
            for (Map<String,Object> map:maps) {
                System.out.println(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //qr的查询操作:根据列ColumnHandler
    @Test
    public void test6(){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="select * from stu";
            //返回list
            List<Object> lists = qr.query(sql, new ColumnListHandler("name"));
            for (Object object:lists) {
                System.out.println(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

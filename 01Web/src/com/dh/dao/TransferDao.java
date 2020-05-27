package com.dh.dao;

import com.dh.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferDao {


    //转出，减钱
    public void out(Connection conn,String out, Double money) throws SQLException {//同一conn，采用方法传参
        QueryRunner qr=new QueryRunner();//无参的进行事务控制，conn
        String sql="update account set money=money-? where name=?";
        qr.update(conn, sql,money,out);
    }

    //转入，加钱
    public void in(Connection conn,String in, Double money) throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="update account set money=money+? where name=?";
        qr.update(conn, sql,money,in);
    }
}

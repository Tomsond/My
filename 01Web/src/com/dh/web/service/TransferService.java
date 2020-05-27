package com.dh.web.service;

import com.dh.dao.TransferDao;
import com.dh.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferService {

    public boolean transfer(String out, String in, double money) {
        TransferDao dao=new TransferDao();
        boolean success=true;
        Connection conn= null;
        try {
            conn = DataSourceUtils.getConnection();
            conn.setAutoCommit(false);

            //调用dao转出钱
            dao.out(conn,out,money);

            //测试出现异常
            int i=10/0;

            //转入钱
            dao.in(conn,in,money);

            conn.commit();
        } catch (Exception e) {
            //异常了就失败
            success=false;
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return  success;
    }
}

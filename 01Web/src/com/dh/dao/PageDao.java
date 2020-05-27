package com.dh.dao;

import com.dh.domain.Student;
import com.dh.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class PageDao {
    public int getTotalCount() throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from test";
        Long query = (Long) qr.query(sql, new ScalarHandler());
        return query.intValue();
    }

    public List<Student> getList(int start,int pageSize) throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from test limit ?,?";
        return qr.query(sql, new BeanListHandler<Student>(Student.class), start, pageSize);
    }
}

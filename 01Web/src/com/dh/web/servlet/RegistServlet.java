package com.dh.web.servlet;

import com.dh.domain.User;
import com.dh.utils.C3P0Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "RegistServlet",urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文乱码
        request.setCharacterEncoding("UTF-8");

        //封装表单数据
        User user=new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map); //BeanUtils工具类,根据表单的name与实体属性一一对应
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //设置隐藏的id
        user.setId(3);
        //调用regist()
        try {
            regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void regist(User user) throws SQLException {
        QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
        String sql="insert into user values(?,?,?)";
        qr.update(sql, user.getId(),user.getUsername(),user.getPassword());
    }
}

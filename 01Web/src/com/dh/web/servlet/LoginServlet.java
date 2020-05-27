package com.dh.web.servlet;

import com.dh.domain.User;
import com.dh.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    //统计访问次数
    @Override
    public void init() throws ServletException {
        int count=0;
        this.getServletContext().setAttribute("count", count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.与数据库校验DBUtils
        QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
        String sql="select * from user where username=? and password=?";
        User user=null;
        try {
            user=qr.query(sql, new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user != null){
           // response.getWriter().write(user.toString()); //登录成功

            //登录成功这里，就加一
            Integer count=(Integer) this.getServletContext().getAttribute("count");
            count++;
            response.getWriter().write(user.toString()+count);
            this.getServletContext().setAttribute("count", count); //最后再设回来
        }else{
            response.getWriter().write("sorry wrong"); //登录失败
        }
    }
}

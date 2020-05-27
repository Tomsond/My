package com.dh.web.servlet;

import com.dh.domain.PageBean;
import com.dh.domain.Student;
import com.dh.web.service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PageServlet",urlPatterns = "/PageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageService service=new PageService();

        //拿到当前页
        String currentPageStr=request.getParameter("currentPage");
        //判断当前页为空
        if(currentPageStr == null) currentPageStr="1";
        int currentPage=Integer.parseInt(currentPageStr);
        int pageSize=2;

        PageBean<Student> pageBean= null;
        try {
            pageBean = service.findPageBean(currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/pagebean.jsp").forward(request,response);
    }
}

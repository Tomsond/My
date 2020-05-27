package com.dh.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxServlet1",urlPatterns = "/AjaxServlet1")
public class AjaxServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        System.out.println(name+"  "+age);
//        int i=1/0;    演示.ajax请求失败
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"name\":\"张三\",\"age\":23}");
    }
}

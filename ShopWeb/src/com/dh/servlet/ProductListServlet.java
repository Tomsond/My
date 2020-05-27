package com.dh.servlet;

import com.dh.domain.PageBean;
import com.dh.domain.Product;
import com.dh.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet",urlPatterns = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    //分页用
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service=new ProductService();

        //拿到当前页参数
        String currentPageStr=request.getParameter("currentPage");
        if(currentPageStr == null) currentPageStr="1";
        //转为int
        int currentPage=Integer.parseInt(currentPageStr);
        //定义pageSize
        int pageSize=12;

        PageBean<Product> pageBean=null;
        try {
            pageBean=service.findPageBean(currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }
}

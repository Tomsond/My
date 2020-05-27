package com.dh.servlet;

import com.dh.domain.Product;
import com.dh.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminProductListServlet",urlPatterns = "/AdminProductListServlet")
public class AdminProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //没有参数调用service
        AdminProductService service=new AdminProductService();
        List<Product> productList=null;
        try {
            productList=service.findAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //保存到request
        request.setAttribute("productList", productList);
        //转发到list.jsp
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
    }
}

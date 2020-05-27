package com.dh.web.servlet;

import com.dh.web.service.TransferService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransferServlet",urlPatterns = "/TransferServlet")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //封装参数
        String out = request.getParameter("out");
        String in = request.getParameter("in");
        String moneyStr = request.getParameter("money");
        //转为double
        double money=Double.parseDouble(moneyStr);

        //调用service
        TransferService service=new TransferService();
        boolean success=service.transfer(out,in,money);
        if(success){
            response.getWriter().write("转账成功！");
        }else{
            response.getWriter().write("转账失败！");
        }
    }
}

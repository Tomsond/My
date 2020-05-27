package com.my.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author：Jiang
 * Date：2019/12/22
 * Time：17:29
 */
@WebServlet(name = "CheckUserServlet",urlPatterns = "/checkUserServlet")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码格式
//        response.setContentType("text/html;charset=utf-8"); 此处若为html，客户端的$.get()的type不用定义为json
        response.setContentType("application/json;charset=utf-8");
        //2.获取参数
        String username = request.getParameter("username");
        //3.存放isExist、msg
        Map<String,Object> map = new HashMap<String, Object>();
        if("tom".equals(username)){
            map.put("isExist",true);
            map.put("msg","用户名已存在");
        }else{
            map.put("isExist",false);
            map.put("msg","用户名可用");
        }
        //4.将map转为json
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

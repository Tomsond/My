package com.dh.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 测试servlet的生命周期
 */
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init启动了。。。");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()。。。");
    }

    @Override
    public void destroy() {
        System.out.println("destroy销毁了。。。");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}

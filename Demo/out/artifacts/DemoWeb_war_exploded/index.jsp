<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/7
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我的idea第一个页面</title>
  </head>
  <body>
  <!--简单的表单登录-->

  <form action="addUser" method="post">
    用户名：<input type="text" name="username"/><br/>
    年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
  </form>
  </body>
</html>

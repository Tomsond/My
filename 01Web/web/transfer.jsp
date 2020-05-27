<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 2018/12/29
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/TransferServlet" method="post">
        转出账户:<input type="text" name="out"/><br>
        转入账户:<input type="text" name="in"/><br>
        金    额:<input type="text" name="money"/><br>
        <input type="submit" value="确认转账"/>
    </form>
</body>
</html>

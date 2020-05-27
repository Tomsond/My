<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/11
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>分页</title>
</head>
<body>
<table align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
    </tr>
</table>
<table align="center">
    <c:forEach items="${pageBean.pageList}" var="page">
        <tr>
            <td>${page.id}</td>
            <td>${page.name}</td>
        </tr>

    </c:forEach>
</table>

共有${pageBean.totalCount}个学生，分为${pageBean.pageSize}页
    <%--分页--%>
    <%--如果当前为第一页--%>
    <c:if test="${pageBean.currentPage == 1}">
        <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
            <c:if test="${pageBean.currentPage == page}">
                ${page}  <%--如果是当前页就不能点击，不是超链接--%>
            </c:if>
            <c:if test="${pageBean.currentPage != page}">
                <a href="${pageContext.request.contextPath}/PageServlet?currentPage=${page}">${page}</a>  <%--如果是当前页就不能点击，不是超链接--%>
            </c:if>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/PageServlet?currentPage=${pageBean.currentPage+1}">下一页</a>
    </c:if>
    <%--如果当前页是中间页--%>
    <c:if test="${pageBean.currentPage > 1 && pageBean.currentPage < pageBean.totalPage}">
        <a href="${pageContext.request.contextPath}/PageServlet?currentPage=${pageBean.currentPage-1}">上一页</a>
        <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
            <c:if test="${pageBean.currentPage == page}">
                ${page}  <%--如果是当前页就不能点击，不是超链接--%>
            </c:if>
            <c:if test="${pageBean.currentPage != page}">
                <a href="${pageContext.request.contextPath}/PageServlet?currentPage=${page}">${page}</a>  <%--如果是当前页就不能点击，不是超链接--%>
            </c:if>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/PageServlet?currentPage=${pageBean.currentPage+1}">下一页</a>
    </c:if>
    <%--如果当前页是最后页--%>
    <c:if test="${pageBean.currentPage > 1 && pageBean.currentPage < pageBean.totalPage}">
        <a href="${pageContext.request.contextPath}/PageServlet?currentPage=${pageBean.currentPage-1}">上一页</a>
        <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
            <c:if test="${pageBean.currentPage == page}">
                ${page}  <%--如果是当前页就不能点击，不是超链接--%>
            </c:if>
            <c:if test="${pageBean.currentPage != page}">
                <a href="${pageContext.request.contextPath}/PageServlet?currentPage=${page}">${page}</a>  <%--如果是当前页就不能点击，不是超链接--%>
            </c:if>
        </c:forEach>
    </c:if>
</body>
</html>

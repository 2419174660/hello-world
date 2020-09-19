<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/14
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
我在检测自己的配置环境${NAME}
<table cellpadding="0" cellspacing="0" class="list_hy">
    <tr>

        <th scope="col">名称</th>
        <th scope="col">地址</th>
        <th scope="col">操作</th>
    </tr>
    <c:forEach items="${LIST}" var="dep">
        <tr>
            <td>${dep.name}</td>
            <td>${dep.address}</td>
            <td>
                <a href="add.html" class="btn">编辑</a>
                <a href="#" class="btn">删除</a>
            </td>
        </tr>

    </c:forEach>
</table>
<%--这是el表达式--%>
</body>
</html>

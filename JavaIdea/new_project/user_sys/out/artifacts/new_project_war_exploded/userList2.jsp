<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/9
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="center" width="600px">
        <tr>
            <th>序号</th>
            <th>用户ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>用户角色</th>
            <th>用户状态</th>
        </tr>
        <c:set var="i" scope="session">1</c:set>
        <c:forEach var="user" items="${sessionScope.users}" varStatus="index">
            <tr align="center">
                <td><c:out value="${index.index+1}">a</c:out></td>
                <td>${user.uid}</td>
                <td>${user.uname}</td>
                <td><button type="button" onclick="">重置密码</button></td>
                <td>${user.urole}</td>
                <td><button type="button" onclick="location.href=''">${user.ustatus=="Normal"?"冻结账户":"解冻账户"}</button></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="com.sia.bean.User" %>
<%@ page import="com.sia.bean.PageNum" %><%--
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
        <c:forEach var="user" items="${sessionScope.users}" varStatus="index"
            begin="${sessionScope.pn.pageNum*3-3}" end="${sessionScope.pn.pageNum*3-1}">
            <tr align="center">
                <td><c:out value="${index.index+1}" /></td>
                <td>${user.uid}</td>
                <td>${user.uname}</td>
                <td><button type="button" onclick="location.href='managerChangeUserPass.jsp?uid=${user.uid}'">重置密码</button></td>
                <td>${user.urole}</td>
                <td><button type="button" onclick="location.href='managerChangerUserStatus.do?uid=${user.uid}'">${user.ustatus=="Normal"?"冻结账户":"解冻账户"}</button></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="right">
                <button type="button" onclick="location.href='getAllUser.do?n=1'">首页</button>
                <button type="button" onclick="location.href='getAllUser.do?n=2'">前一页</button>
                <button type="button" onclick="location.href='getAllUser.do?n=3'">下一页</button>
                <button type="button" onclick="location.href='getAllUser.do?n=4'">尾页</button>
                &nbsp;&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</body>
</html>

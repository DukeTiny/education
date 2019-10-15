<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/6/5
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>UserList</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        function changePage() {
            var size = $("#size").val();
            location.href = "User_find?p=${requestScope.page.p}&size="+size;
        }
    </script>
    <style>
        table{
            border-top:1px lightgray solid;
        }
        td{
            border-bottom: 1px lightgray solid;
            line-height: 50px;
            color: rgb(80,80,80);
            font-size: 18px;
        }
        a{
            text-decoration: none;
            cursor: pointer;
        }
        a:link,a:visited{
            color: rgb(80,80,80);
        }
        a:hover,a:active{
            color: blueviolet;
        }
    </style>
</head>
<body>
    <table cellspacing="0" cellpadding="3" align="center" style="width:100%;">
        <caption><font size="5">User List</font></caption>
        <tr align="center">
            <td>ID</td>
            <td>Username</td>
            <td>Birthday</td>
            <td>Money</td>
            <td>删除/修改</td>
        </tr>
        <c:forEach var="user" items="${requestScope.page.list}" >
            <tr align="center">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.birthday}</td>
                <td>${user.money}</td>
                <td><a href="User_delete?id=${user.id}&size=${requestScope.page.size}">删除</a> | <a href="User_updateUI?id=${user.id}&size=${requestScope.page.size}">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="right">
                <c:if test="${requestScope.page.p!=1}">
                    <a href="User_find?p=1&size=${requestScope.page.size}">首页</a>
                    <a href="User_find?p=${requestScope.page.prev}&size=${requestScope.page.size}">前一页</a>
                </c:if>
                <c:forEach begin="${requestScope.page.startPage}" end="${requestScope.page.endPage}" var="index">
                    <c:if test="${requestScope.page.p eq index}"><font color="#d3d3d3">${index}</font></c:if>
                    <c:if test="${requestScope.page.p ne index}"><a href="User_find?p=${index}&size=${requestScope.page.size}">${index}<a></c:if>
                </c:forEach>
                <c:if test="${requestScope.page.p != requestScope.page.maxPage }">
                    <a href="User_find?p=${requestScope.page.next}&size=${requestScope.page.size}">下一页</a>
                    <a href="User_find?p=${requestScope.page.maxPage}&size=${requestScope.page.size}">尾页</a>
                </c:if>
            </td>
            <td>
                <strong>第${requestScope.page.p}页</strong>/共${requestScope.page.maxPage}页
                一页显示
                <select onchange="changePage()" id="size">
                    <c:forEach begin="1" end="15" var="index">
                        <c:if test="${requestScope.page.size eq index}">
                            <option selected>${index}</option>
                        </c:if>
                        <c:if test="${requestScope.page.size ne index}">
                            <option>${index}</option>
                        </c:if>
                    </c:forEach>
                </select>
                页
            </td>
        </tr>
    </table>
</body>
</html>

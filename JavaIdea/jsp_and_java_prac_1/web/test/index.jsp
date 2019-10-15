<%@ page import="com.sia.bean.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sia.dao.CourseDao" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/6
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table width="400" align="center" cellspacing="0" cellpadding="3" border="1">
    <tr>
        <th>序号</th>
        <th>课程号</th>
        <th>课程名</th>
        <th>课程人数</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
        <%
            List<Course> list = (List<Course>)request.getAttribute("list");
            for ( int i=0;i <list.size();i++ ){
        %>
            <tr>
                <td><%= (i+1)%></td>
                <td><%= list.get(i).getCno()%></td>
                <td><%= list.get(i).getCname()%></td>
                <td><%= list.get(i).getCnum()%></td>
                <td><button onclick="location.href='getEditCourse.do?cno=<%= list.get(i).getCno()%>'">编辑</button></td>
                <td><button onclick="location.href='delCourse.do?cno=<%= list.get(i).getCno()%>'">删除</button></td>
            </tr>
        <%
             }
        %>
</table>
    <span align="center"><button onclick="location.href='addForm.jsp'">添加</button></span>
</body>
</html>



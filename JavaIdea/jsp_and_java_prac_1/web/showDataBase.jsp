<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sia.bean.Course" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/6
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table width="400" align="center" cellspacing="0" cellpadding="3" border="1">
        <tr>
            <th>序号</th>
            <th>课程号</th>
            <th>课程名</th>
            <th>课程人数</th>
        </tr>
        <%
            List<Course> list = (List<Course>) request.getAttribute("list");
            for( int i=0; i<list.size(); i++ ){
                out.print("<tr align='center'>");
                out.print("<td>"+(i+1)+"</td>");
                out.print("<td>"+list.get(i).getCno()+"</td>");
                out.print("<td>"+list.get(i).getCname()+"</td>");
                out.print("<td>"+list.get(i).getCnum()+"</td>");
                out.print("</tr>");
            }
        %>
    </table>
</body>
</html>

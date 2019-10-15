<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sia.user.User" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    Welcome ${sessionScope.loginUser}<br />
    在线人数为：<%= User.vectors.size()%><br />
    <%
        System.out.println(User.vectors.size());
        for(int i = 0; i<User.vectors.size(); i++ ){
    %>
             <%=User.vectors.get(i)%>
    <%
        }
        out.print("<br />");
    %>
    <a href="Exit.do">LoginOut</a>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/30
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String uname = request.getParameter("uname");
        out.print( uname );
        String[] hobbies = request.getParameterValues("hobbies");
        for ( String s:hobbies ){
            out.print(s);
        }
    %>
</body>
</html>

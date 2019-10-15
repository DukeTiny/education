<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/3
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String[] hobbies = request.getParameterValues("hobbies");
        for( String s:hobbies ) {
            out.println(s);
        }
    %>
</body>
</html>

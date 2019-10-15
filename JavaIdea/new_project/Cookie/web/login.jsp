<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>THIS IS A LOGIN PAGE</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.length);
        for( Cookie c:cookies ){
            if( c.getName().equals("uname") && c.getValue().equals("admin") ){
                response.sendRedirect("login.do?uname="+c.getValue());
            }
        }
    %>
    <form action="login.do" method="post">
        <input type="text" name="loginUser">
        <button>Submit</button>
    </form>
</body>
</html>

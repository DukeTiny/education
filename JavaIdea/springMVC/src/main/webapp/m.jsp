<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/6/27
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>M.jsp</title>
</head>
<body>
<h3>M.JSP</h3>

    <form action="users" method="post">
        <button type="submit">Post</button>
    </form>

<form action="users" method="get">
    <button>get</button>
</form>

<form action="users/1" method="get">
    <button>getOne</button>
</form>

<form action="users" method="post">
    <input type="hidden" name="_method" value="PUT">
    <button>Put</button>
</form>

<form action="users" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <button>Delete</button>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/7
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserChangePass</title>
</head>
<body>
    <form action="../managerChangeUserPass.do" method="get">
        <input type="hidden" name="uname" value="<%= request.getParameter("uname")%>">
        <input type="hidden" name="oldUpwd" value="<%= request.getParameter("upwd")%>">
        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="upwd">
        <br />
        重复密码：<input type="text" name="repeatUpwd">
        <button>修改</button>
    </form>
</body>
</html>

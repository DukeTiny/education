<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/7
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <div style="margin: auto; padding: 30px; border: 1px solid black; width: 220px;">
        <form action="../userLogin.do" method="post">
            用户名：<input type="text" name="uname" />
            <br />
            密&nbsp;&nbsp;&nbsp;码：<input type="text" name="upwd" />
            <br />
            <button>提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" onclick="location.href='reg.jsp'">注册</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset">重置</button>
        </form>
    </div>
  </body>
</html>

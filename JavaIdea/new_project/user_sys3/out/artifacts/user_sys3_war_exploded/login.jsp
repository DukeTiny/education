<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/9
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
      session.setAttribute("a","A");
      session.setAttribute("b","B");
  %>
    <div style="border: 1px gray solid; width: 200px; height:90px; padding: 10px 10px 0 10px; margin:0 auto; border-radius: 5px;">
        <form action="doLogin.do" method="post">
            用户名：<input type="text" name="uname"><br />
            密&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd">
            <table width="200" cellpadding="10" cellspacing="0">
                <tr>
                    <td><button>登录</button></td>
                    <td><button type="button" onclick="location.href='reg.jsp'">注册</button></td>
                    <td><button type="reset">重置</button></td>
                </tr>
            </table>
        </form>
    </div>
  </body>
</html>

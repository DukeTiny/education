<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/9
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border: 1px gray solid; width: 200px; height:90px; padding: 10px 10px 0 10px; margin:0 auto; border-radius: 5px;">
    <form action="rge.do" method="post">
        用户名：<input type="text" name="uname"><br />
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd">
        <%--<input type="radio" name="urole" checked value="普通用户"/>普通用户--%>
        <%--<input type="radio" name="urole" value="管理员"/>管理员--%>
        <table width="200" cellpadding="10" cellspacing="0">
            <tr align="center">
                <td><button>注册</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

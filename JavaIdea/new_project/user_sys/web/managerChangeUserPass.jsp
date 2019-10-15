<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/9
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="border: 1px gray solid; width: 220px; height:90px; padding: 10px 10px 0 10px; margin:0 auto; border-radius: 5px;">
        <form action="managerChangerUserPass.do" method="post">
            <input type="hidden" name="uid" value="<%= request.getParameter("uid")%>">
            新密码：&nbsp;&nbsp;&nbsp;<input type="password" name="newPwd"><br />
            重复密码：<input type="password" name="repeatNewPwd">
            <table width="200" cellpadding="10" cellspacing="0">
                <tr align="center">
                    <td><button>修改</button></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>

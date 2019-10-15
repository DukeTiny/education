<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/6/25
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>H.jsp</title>
</head>
<body>
    ${requestScope.str}
    <hr />
    ${requestScope.user.id}
    ${requestScope.user.name}
    ${requestScope.user.birthday}
    ${requestScope.user.money}
</body>
</html>

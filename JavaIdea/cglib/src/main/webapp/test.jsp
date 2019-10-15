<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/8/7
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <c:forEach var="p" items="${stringList}">
        <h3>${p}</h3>
    </c:forEach>
    ${string}
    ${arrayList}
</body>
</html>

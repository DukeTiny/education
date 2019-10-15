<%@ page import="com.sia.bean.Course" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/6
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form method="post" action="course.add">
        cno:<input type="text" name="cno" />
        cname:<input type="text" name="cname" />
        cnum:<input type="text" name="cnum" />
        <button>提交</button>
    </form>
</body>
</html>

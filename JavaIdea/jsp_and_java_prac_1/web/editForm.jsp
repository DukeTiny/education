<%@ page import="com.sia.bean.Course" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/6
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Course course = (Course)request.getAttribute("course");
    %>
    <form method="post" action="updateEditCourse.do">
        <input type="hidden" name="cno" value="<%= course.getCno()%>"/>
        cname:<input type="text" name="cname" value="<%= course.getCname()%>"/>
        cnum:<input type="text" name="cnum" value="<%= course.getCnum()%>"/>
        <button>提交</button>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/6
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sia.bean.Course" %>
<%@ page import="com.sia.dao.CourseDao" %>
<html>
<head>
<title>Title</title>
</head>
    <body>
    <%
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String cnum = request.getParameter("cnum");
        Course controller.AddCourse = new Course(cno,cname,cnum);
        CourseDao cd = new CourseDao();
        cd.add(course);
        response.sendRedirect("index.jsp");
    %>
</body>
</html>

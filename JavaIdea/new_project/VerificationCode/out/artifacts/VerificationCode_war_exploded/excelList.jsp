<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/16
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        File[] files = (File[]) request.getAttribute("files");
        for( int i=0; i<files.length; i++ ){
    %>
        <a href="download.do?fileName=<%= files[i].getName()%>"><%= files[i].getName()%></a><br />
    <%
        }
    %>


</body>
</html>

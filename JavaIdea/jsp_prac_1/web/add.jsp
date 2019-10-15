<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/5
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8","root","wh809919");
    String sql = "INSERT INTO stu VALUES(?,?,?)";
    PreparedStatement ps = conn.prepareStatement( sql );
    ps.setInt(1,Integer.parseInt( request.getParameter("sno")) );
    ps.setString(2,request.getParameter("sname") );
    ps.setString(3,request.getParameter("sgender") );
    ps.executeUpdate();
    response.sendRedirect("index.jsp");
%>

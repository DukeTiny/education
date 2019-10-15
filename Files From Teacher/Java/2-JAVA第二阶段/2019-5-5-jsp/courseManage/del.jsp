<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8", "root", "woniu");
	String sql = "delete from course where cno=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1,request.getParameter("cno"));
	int rows = ps.executeUpdate();
	response.sendRedirect("courseList.jsp");
%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8", "root", "woniu");
	String sql = "update course set cname=?,tno=? where cno=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1,request.getParameter("cname"));
	ps.setString(2,request.getParameter("tno"));
	ps.setString(3,request.getParameter("cno"));
	int rows = ps.executeUpdate();
	response.sendRedirect("courseList.jsp");
	/* if(rows>0){
		response.sendRedirect("courseList.jsp");
	}else{
		response.sendRedirect("error.jsp");
	} */
%>
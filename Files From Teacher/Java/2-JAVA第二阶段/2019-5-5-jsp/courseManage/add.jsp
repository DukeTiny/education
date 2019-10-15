<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8", "root", "woniu");
	String sql = "insert into course values(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1,request.getParameter("cno"));
	ps.setString(2,request.getParameter("cname"));
	ps.setString(3,request.getParameter("tno"));
	int rows = ps.executeUpdate();
	if(rows>0){
		response.sendRedirect("courseList.jsp");
	}else{
		response.sendRedirect("error.jsp");
	} 
%>
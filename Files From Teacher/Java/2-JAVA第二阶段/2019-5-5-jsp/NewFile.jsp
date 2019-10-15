<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" border="1" align="center">
		<caption>课程管理</caption>
		<tr>
			<th>序号</th>
			<th>课程号</th>
			<th>课程名称</th>
			<th>教师号</th>
		</tr>
	<%
		//数据库连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8","root","woniu");
		String sql = "select * from course";
		PreparedStatement ps = conn.prepareStatement(sql);
		//读取所有课程信息
		ResultSet rs = ps.executeQuery();
		//使用html展现课程信息
		//while(rs.next()){
		//	out.println("<tr>");
		//	out.println("<td>"+(rs.getRow())+"</td>");
		//	out.println("<td>"+rs.getString(1)+"</td>");
		//	out.println("<td>"+rs.getString(2)+"</td>");
		//	out.println("<td>"+rs.getString(3)+"</td>");
		//	out.println("</tr>");
		//}
		while(rs.next()){
		%>
			<tr>
				<th><%=rs.getRow() %></th>
				<th><%=rs.getString(1) %></th>
				<th><%=rs.getString(2) %></th>
				<th><%=rs.getString(3) %></th>
			</tr>
		<%	
		}
	%>
	</table>
</body>
</html>
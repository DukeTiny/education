<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8","root","woniu");
		String sql = "select * from course where cno=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, request.getParameter("cno"));
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
	%>
	<form action="edit.jsp">
		<input type="hidden" name="cno" value="<%=rs.getString(1) %>" />
		课程名:<input type="text" name="cname" value="<%=rs.getString(2) %>"  />
		教师号:<input type="text" name="tno" value="<%=rs.getString(3) %>"  />
		<button>edit</button>
	</form>
	<%
		}
	%>
</body>
</html>
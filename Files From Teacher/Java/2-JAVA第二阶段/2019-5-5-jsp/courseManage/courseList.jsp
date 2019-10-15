<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delCourse(val){
		var sel = window.confirm("您是否要删除当前课程?");
		if(sel){
			location.href='del.jsp?cno='+val;
		}
	}
</script>
</head>
<body>
	<form action="courseList.jsp" method="post">
		<input type="text" name="likeName" />
		<input type="text" name="tno" />
		<button>查询</button>
	</form>
	<%
		String likeName = request.getParameter("likeName");
		String tno = request.getParameter("tno");
		if(likeName!=null&&!likeName.trim().equals("")){
			//如果有乱码，使用下面代码对字符串进行转码
			likeName = new String(likeName.getBytes("iso8859-1"),"utf-8");
		}
		out.println(likeName);
	%>
	<table width="800" border="1" align="center">
		<caption>课程管理</caption>
		<tr>
			<th>序号</th>
			<th>课程号</th>
			<th>课程名称</th>
			<th>教师号</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
	<%
		//数据库连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8","root","woniu");
		String sql = "select * from course where 1=1 ";
		if(likeName!=null&&!likeName.trim().equals("")){
			sql += "and cname like ? ";
		}
		if(tno!=null&&!tno.trim().equals("")){
			sql += "and tno=? ";
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		int count = 1;
		if(likeName!=null&&!likeName.trim().equals("")){
			ps.setString(count++,"%"+likeName+"%");
		}
		if(tno!=null&&!tno.trim().equals("")){
			ps.setString(count++,tno);
		}
		//读取所有课程信息
		ResultSet rs = ps.executeQuery();
		//使用html展现课程信息
		/* while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+(rs.getRow())+"</td>");
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td></td>");
			out.println("</tr>");
		//} */
		while(rs.next()){
			//out.println("<td><button type='button' onclick='location.href='del.jsp?cno="+rs.getString(1)+"''></button></td>");
		%>
			<tr>
				<th><%=rs.getRow() %></th>
				<th><%=rs.getString(1) %></th>
				<th><%=rs.getString(2) %></th>
				<th><%=rs.getString(3) %></th>
				<th><button type="button" onclick="location.href='courseEdit.jsp?cno=<%=rs.getString(1) %>'">编辑</button></th>
				<th><button type="button" onclick="delCourse('<%=rs.getString(1) %>')">删除</button></th>
			</tr>
		<%	
		
		}
	%>
	
	</table>
	<button type="button" onclick="location.href='courseAdd.jsp'">添加课程</button>
</body>
</html>
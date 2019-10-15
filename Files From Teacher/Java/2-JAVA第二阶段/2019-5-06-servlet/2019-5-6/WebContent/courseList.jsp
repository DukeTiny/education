<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.woniu.bean.Course" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>序号</th>
			<th>课程号</th>
			<th>课程名</th>
			<th>教师号</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<%
			List<Course> courses = (List<Course>)request.getAttribute("list");
			for(int i=0;i<courses.size();i++){
				Course c = courses.get(i);
		%>
				<tr>
					<th><%=(i+1) %></th>
					<th><%=c.getCno() %></th>
					<th><%=c.getCname() %></th>
					<th><%=c.getTno() %></th>
					<th><a href="getCourse.do?cno=<%=c.getCno() %>">编辑</a></th>
					<th><a href="courseDel.do?cno=<%=c.getCno() %>">删除</a></th>
				</tr>
		<%
			}
		%>
	</table>
	<button type="button" onclick="location.href='courseAddForm.jsp'">添加课程</button>
</body>
</html>
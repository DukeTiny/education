<%@page import="com.woniu.bean.Stu"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>
	<table width="800" border="1" align="center">
		<caption>学生管理</caption>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>照片</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<%
			List<Stu> stus = (List<Stu>)request.getAttribute("stus");
			/* String url = request.getRequestURL().toString();
			url = url.substring(0,url.lastIndexOf("/"));
			out.println(url); */
			for(int i=0;i<stus.size();i++){
				Stu s = stus.get(i);
				%>
					<tr>
						<th><%=i+1 %></th>
						<th><%=s.getSname() %></th>
						<th><img src="<%=request.getContextPath()+s.getSphoto() %>" width="200" /></th>
						<th><a href="stu.do?method=findOne&sid=<%=s.getSid()%>">编辑</a></th>
						<th><a href="stu.do?method=del&sid=<%=s.getSid()%>">删除</a></th>
					</tr>
				<%
			}
		%>
	</table>
</body>
</html>
<%@page import="com.woniu.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
</head>
<body>
	欢迎
	<% 
		User user = (User)session.getAttribute("loginUser");
		out.println(user.getUname());
	%>
	登录，<a href="UserExit.do">退出</a>
	<table width="800" border="1" align="center">
		<caption>用户管理</caption>
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>权限</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<%
			//获得转发过来的数据
			List<User> users = (List<User>)request.getAttribute("users");
			for(int i=0;i<users.size();i++){
				User u = users.get(i);
				%>
					<tr>
						<th><%=(i+1) %></th>
						<th><%=u.getUname() %></th>
						<th><a href="ResetPwd.do?uid=<%=u.getUid()%>">重置密码</a></th>
						<th><%=u.getUrole() %></th>
						<th><a href="GetUser.do?uid=<%=u.getUid()%>">编辑</a></th>
						<th><a href="UserDel.do?uid=<%=u.getUid()%>">删除</a></th>
					</tr>
				<%
			}
		%>
	</table>
</body>
</html>
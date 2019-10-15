<%@page import="com.woniu.bean.PageBean"%>
<%@page import="com.woniu.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" border="1" align="center">
		<caption>用户管理</caption>
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>角色</th>
			<th>状态</th>
		</tr>
		<%
			PageBean pb = (PageBean)request.getAttribute("pb");
			List<User> users = (List<User>)request.getAttribute("users");
			for(int i=0;i<users.size();i++){
					User u = users.get(i);
					
					%>
						<tr>
							<th><%=((pb.getPageNum()-1)*pb.getPageRow()+i+1) %></th>
							<th><%=u.getUname() %></th>
							<th><%=u.getUpwd() %></th>
							<th><%=u.getUrole() %></th>
							<th><%=u.getUstate() %></th>
						</tr>
					<%
			}
		%>
		<tr>
			<th colspan="5">
				<a href="UserList2.do?pageNum=1">首页</a>
				<a href="UserList2.do?pageNum=<%=pb.getPageNum()==1?1:pb.getPageNum()-1%>">上一页</a>
				<a href="UserList2.do?pageNum=<%=pb.getPageNum()==pb.getCountPage()?pb.getCountPage():pb.getPageNum()+1 %>">下一页</a>
				<a href="UserList2.do?pageNum=<%=pb.getCountPage()%>">末页</a>
			</th>
		</tr>
	</table>
</body>
</html>
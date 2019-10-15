<%@page import="com.woniu.bean.Stu"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Stu s= (Stu)request.getAttribute("stu");
	%>
	<form action="stu.do?method=edit" method="post" enctype="multipart/form-data">
		<input type="hidden" name="sid" value="<%=s.getSid() %>" />
		学生姓名:<input type="text" name="sname" value="<%=s.getSname() %>" />
		学生照片:<img src="<%=request.getContextPath()+s.getSphoto() %>" width="200" /><input type="file" name="sphoto" />
		<button>修改</button>
	</form>
</body>
</html>
<%@ page language="java" pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("user", "admin"); //创建 添加
		session.setAttribute("user", "abc");  //替换
		session.removeAttribute("user"); //移除
		session.invalidate();
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ com.woniu.bean.User%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center" border="1">
	<caption>用户列表</caption>
	<tr>
		<th>序号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>年龄</th>
		<th>编辑</th>
		<th>删除</th>
	</tr>
<c:forEach var="user" items="${login }" varStatus="i">

<tr>
<th>${i.idex+1}</th>
<th>${user.uname}</th>
<th>${user.sex}</th>
<th>${user.ago}</th>
<th><a href="">编辑</a></th>
<th><a href="">删除</a></th>
</tr>


</c:forEach>




</table>



</body>
</html>
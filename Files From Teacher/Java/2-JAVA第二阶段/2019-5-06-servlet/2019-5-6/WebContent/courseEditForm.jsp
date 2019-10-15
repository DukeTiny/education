<%@page import="com.woniu.bean.Course"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		Course c = (Course)request.getAttribute("c");
		if(c!=null){
	%>
	<form action="courseEdit.do" method="post">
		<input type="hidden" name="cno" value="<%=c.getCno() %>" />
		课程名<input type="text" name="cname" value="<%=c.getCname() %>" />
		教师号<input type="text" name="tno" value="<%=c.getTno() %>" />
		<button>修改</button>
	</form>
	<%
		}
	%>
</body>
</html>
<%@page import="com.woniu.bean.User"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
<script type="text/javascript">
	function checkUname(){
		location.href="User.do?method=checkUname&uname="+document.getElementById("uname").value;
	}
</script>
</head>
<body>
	<%
		Object obj = request.getAttribute("info");
		String s = "";
		if(obj!=null){
			s = (String)obj;
		}
	%>
	<form action="UserReg.do" method="post">
		uname:<input type="text" name="uname" id="uname" /><%=s %><button type="button" onclick="checkUname()">检查用户名</button><br>
		upwd:<input type="password" name="upwd" /><br>
		<input type="submit" value="注册" />
		<input type="reset" value="重置" />
			
	</form>
</body>
</html>
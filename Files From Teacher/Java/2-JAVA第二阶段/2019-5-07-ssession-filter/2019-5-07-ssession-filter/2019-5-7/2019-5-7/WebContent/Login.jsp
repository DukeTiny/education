<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
</head>
<body>
	<form action="UserLogin.do" method="post">
		uname:<input type="text" name="uname" /><br>
		upwd:<input type="password" name="upwd" /><br>
		<input type="submit" value="登录" />
		<input type="reset" value="重置" />
		<input type="button" value="注册" onclick="location.href='Reg.jsp'" />
			
	</form>
</body>
</html>
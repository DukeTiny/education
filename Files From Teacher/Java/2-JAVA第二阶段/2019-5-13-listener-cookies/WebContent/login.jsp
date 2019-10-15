<%@ page language="java" pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cs = request.getCookies();
		for(Cookie c:cs){
			if(c.getName().equals("uname")&&c.getValue().equals("admin")){
				response.sendRedirect("login.do?uname="+c.getValue());
			}
		}
	%>
	<form action="login.do" method="post">
		uname<input type="text" name="uname" />
		自动登录保存时间<select name="maxAge">
			<option value="">一天</option>
			<option value="">一周</option>
			<option value="">一年</option>
			<option value="">永久</option>
		</select>
		<button>登录</button>
	</form>
</body>
</html>
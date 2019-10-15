<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%! 
		int num = 10;
		public void show(){
			System.out.println(123);
		}
	%>
	<%=num %>
	<% 
		int num2 = 5;
		out.println(5);
		show();
	%>
	<form action="getData.jsp" method="get">
		用户名<input type="text" name="uname" />
		<input type="checkbox" name="hob" value="basketball" />篮球
		<input type="checkbox" name="hob" value="football"/>足球
		<input type="checkbox" name="hob" value="baseball"/>棒球
		<select name="year">
			<option value="123">11</option>
		</select>
		<input type="submit" value="提交" />
	</form>
</body>
</html>
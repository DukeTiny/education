<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>index.jsp</h3>
	<marquee>
		i can fly!!!
	</marquee>
	<a href="user_save">go to save</a>
	
	<hr />
	
	<form action="user_transfer" method="post">
		from:<input name="from" /> <br />
		to:<input name="to" /> <br />
		to:<input name="to" /> <br />
		to:<input name="to" /> <br />
		money:<input name="money" /> <br />
		<button type="submit">GO</button>
	</form>
</body>
</html>
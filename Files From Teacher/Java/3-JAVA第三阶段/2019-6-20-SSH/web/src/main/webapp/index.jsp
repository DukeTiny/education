<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UserServlet.do" method="post">
		from:<input name="from" /> <br />
		to:<input name="to" /> <br />
		money:<input name="money" /> <br />
		<button type="submit">转账</button>
	</form>

</body>
</html>
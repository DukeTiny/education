<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function reloadImg(){
		document.getElementById("img1").src="image.do?time="+new Date().getTime();
	}
</script>
</head>
<body>
	<form action="login.do" method="post">
		用户名:<input type="text" name="uname" />
		验证码:<input type="text" name="yzm" /><img src="image.do" id="img1" onclick="reloadImg()" />
		<button>登录</button>
	</form>
</body>
</html>
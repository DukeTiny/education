<%@page import="com.woniu.bean.User"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册页面</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
	function checkUname(){
		//生成ajax对象
		var abc = new XMLHttpRequest();
		//设置请求的信息
		abc.open("post","User.do?method=checkUnameAjax&uname="+document.getElementById("uname").value,true);
		//当请求状态发生变化
		abc.onreadystatechange=function(){
			if(abc.readyState==4&&abc.status==200){
				document.getElementById("show").innerHTML = abc.responseText;
			}
		}
		//发送请求
		abc.send();
	}
</script>
</head>
<body>
	
	<form action="UserReg.do" method="post">
		uname:<input type="text" name="uname" id="uname" /><span id="show"></span><button type="button" onclick="checkUname()">检查用户名</button><br>
		upwd:<input type="password" name="upwd" /><br>
		<input type="submit" value="注册" />
		<input type="reset" value="重置" />
			
	</form>
</body>
</html>
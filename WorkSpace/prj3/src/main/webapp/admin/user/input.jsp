<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
		integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
		crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script>
		$(function (){
			<c:forEach items="${user.roles}" var="r">
				$("input[name=rids][value=${r.id}]").attr("checked","checked");
			</c:forEach>
			});
	</script>
	
</head>
<body>
	<br />
	<div class="container">

			<form action="${user==null?"save":"update"}" method="post">
				<div class="form-group">
					<input type="hidden" name="id" value="${user.id}">
					<label>
					Username<input type="text" name="username" value="${user.username}" class="form-control" placeholder="Username">
					</label> 
					<label>
					Password<input type="password" name="password" value="" class="form-control" placeholder="Password">
					</label>
				</div>
				<div class="form-group">
					<input type="radio" name="isDelete" value="false" ${user.delete==null||user.delete==false?'checked':''}> 正常 &nbsp;
					<input type="radio" name="isDelete" value="true"  ${user.delete==null||user.delete==true?'checked':''}> 冻结
				</div>
				<div class="checkbox">
					<c:forEach items="${roles}" var="role">
						<label> <input type="checkbox" name="rids" value="${role.id}"> ${role.name}</label>
					</c:forEach>
				</div>
				<a href=""><button type="submit" class="btn btn-success">${user==null?"save":"update"}</button></a>
				
			</form>

	</div>
</body>
</html>
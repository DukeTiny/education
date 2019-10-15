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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table table-hover">
				<tr>
					<th class="success">用户ID</th>
					<th class="success">用户账户</th>
					<th class="success">用户密码</th>
					<th class="success">用户角色</th>
					<th class="success">状态</th>
					<th class="success">操作</th>
				</tr>
				<c:forEach items="${users}" var="user" varStatus="r">
					<tr>
						<td class="${r.index%2==0?'active':'success' }">${user.id}</td>
						<td class="${r.index%2==0?'active':'success' }">${user.username}</td>
						<td class="${r.index%2==0?'active':'success' }">${user.password}</td>
						<td class="${r.index%2==0?'active':'success' }">${user.roles}</td>
						<td class="${r.index%2==0?'active':'success' }">${user.delete==null||user.delete==false?'未冻结':'已冻结'}</td>
						<td class="${r.index%2==0?'active':'success' }">
						<a href="delete?uid=${user.id}"><button type="button" class="btn btn-danger">Delete</button></a>
						<a href="findById?uid=${user.id}" ><button type="button" class="btn btn-primary">Update</button></a>
						</td>
					<tr>
				</c:forEach>
			</table>
			<a href="goInput"><button type="button" class="btn btn-success">Save</button></a>
		</div>
	</div>
</body>
</html>
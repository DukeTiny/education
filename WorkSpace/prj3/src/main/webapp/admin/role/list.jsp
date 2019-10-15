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
					<th class="success">角色ID</th>
					<th class="success">角色名称</th>
					<th class="success">操作</th>
				</tr>
				<c:forEach items="${roles}" var="role">
					<tr>
						<td class="${r.index%2==0?'active':'success' }">${role.id}</td>
						<td class="${r.index%2==0?'active':'success' }">${role.name}</td>
						</td>
						<td class="${r.index%2==0?'active':'success' }">
							<a href="findById?id=${role.id}" ><button type="button" class="btn btn-primary">Update</button></a>
						</td>
					<tr>
				</c:forEach>
			</table>
			<a href="goInput"><button type="button" class="btn btn-success">Save</button></a>
		</div>
	</div>
</body>
</html>
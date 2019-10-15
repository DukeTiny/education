<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<table class="table table-striped">
  <tr>
  <td class="active">rid</td>
  <td class="success">rname</td>
  <td class="danger">operation</td>
</tr>
<c:forEach items="${list}" var="role">
<tr>
  <td class="active">${role.rid }</td>
  <td class="success">${role.rname }</td>
  <td class="danger">
  <a href="findById?rid=${role.rid}"><button type="button" class="btn btn-success">Update</button></a>
  </td>
</tr>
</c:forEach>
</table>

<a href="goInput"><button type="button" class="btn btn-primary">Save</button></a>
</div>
</body>
</html>
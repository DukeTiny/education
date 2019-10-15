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
  <td class="active">uid</td>
  <td class="success">uname</td>
  <td class="warning">upass</td>
  <td class="warning">delete</td>
  <td class="danger">roles</td>
  <td class="danger">operation</td>
</tr>
<c:forEach items="${list}" var="info">
<tr>
  <td class="active">${info.uid }</td>
  <td class="success">${info.uname }</td>
  <td class="warning">${info.upass }</td>
  <td class="warning">${info.isdelete==null||info.isdelete==false?'可用':'删除'}</td>
  <td class="danger">${info.roles}</td>
  <td class="danger">
  <a href="delete?uid=${info.uid}"><button type="button" class="btn btn-danger">Delete</button></a>
  <a href="findById?uid=${info.uid}"><button type="button" class="btn btn-success">Update</button></a>
  </td>
</tr>
</c:forEach>
</table>

<a href="goInput"><button type="button" class="btn btn-primary">Save</button></a>
</div>
</body>
</html>
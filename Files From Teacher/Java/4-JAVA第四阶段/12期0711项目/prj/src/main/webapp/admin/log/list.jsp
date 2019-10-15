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
<form method="post" action="findAll">
uname:<input type="text" name="uname" value="${log.uname }">
action:<input type="text" name="action" value="${log.action }">
<button type="submit" class="btn btn-primary">Go</button>
<table class="table table-striped">
  <tr>
  <td class="active">logid</td>
  <td class="success">uname</td>
  <td class="warning">action</td>
  <td class="warning">actiontime</td>
  <td class="danger">uid</td>
</tr>
<c:forEach items="${list}" var="log">
<tr>
  <td class="active">${log.logid }</td>
  <td class="success">${log.uname }</td>
  <td class="warning">${log.action }</td>
  <td class="danger">${log.actiontime}</td>
  <td class="danger">${log.uid}</td>
  </td>
</tr>
</c:forEach>
</table>
<table>
<tr>
  <td class="active"><button type="button" onclick="go(1)" class="btn btn-primary">First</button></td>
  <td class="success"><button type="button" onclick="go(${page.pageNow+1})" class="btn btn-primary">Next</button></td>
  <td class="success"><button type="button" onclick="go(${page.pageNow-1})" class="btn btn-primary">Before</button></td>
  <td class="success"><button type="button" onclick="go(${page.pageCount})" class="btn btn-primary">End</button></td>
  <td class="success">pageNow:<input type="text" size="1" value="${page.pageNow}" name="pageNow"></td>
  <td class="success">limit:<input type="text" size="1" value="${page.limit }" name="limit"></td>
  <td class="success">共${page.count}条  共${page.pageCount}页</td>
  <td class="danger"><button type="submit" class="btn btn-primary">Go</button></td>
  </td>
</tr>
</table>
</form>
<a href="goInput"><button type="button" class="btn btn-primary">Save</button></a>
</div>
</body>
</html>
<script>
	function go(pageNow){
		$("input[name=pageNow]").val(pageNow);
		document.forms[0].submit();
	}
</script>
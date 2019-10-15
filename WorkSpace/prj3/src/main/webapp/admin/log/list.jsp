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
	
	<script>
			function first( nowPage ) {
				$("input[name=nowPage]").val(nowPage);
				document.forms[0].submit();
			}
			function previous( nowPage ) {
				$("input[name=nowPage]").val(nowPage);
				document.forms[0].submit();
			}
			function next( nowPage ) {
				$("input[name=nowPage]").val(nowPage);
				document.forms[0].submit();
			}
			function end() {
				$("input[name=nowPage]").val(${page.pageCount});
				document.forms[0].submit();
			}
	</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="findAll" method="post">
			用户：<input type=text name="uname" value="${log.uname}" />
			操作：<input type=text name="action" value="${log.action}" />
			<table class="table table-hover">
				<tr>
					<th class="success">日志ID</th>
					<th class="success">用户ID</th>
					<th class="success">用户名</th>
					<th class="success">行为</th>
					<th class="success">操作时间</th>
					<!-- <th class="success">状态</th>
					<th class="success">操作</th> -->
				</tr>
				<c:forEach items="${logs}" var="log" varStatus="r">
					<tr>
						<td class="${r.index%2==0?'active':'success' }">${log.logid}</td>
						<td class="${r.index%2==0?'active':'success' }">${log.uid}</td>
						<td class="${r.index%2==0?'active':'success' }">${log.uname}</td>
						<td class="${r.index%2==0?'active':'success' }">${log.action}</td>
						<td class="${r.index%2==0?'active':'success' }">${log.actiontime}</td>
					<tr>
				</c:forEach>
				<tr>
					<td colspan="5" class="${r.index%2==0?'active':'success'}">
						<button type="button" onclick="first(1)" class="btn btn-success col-md-1">First</button>
						<button type="button" onclick="previous(${page.nowPage>1?page.nowPage-1:1})" class="btn btn-success col-md-1">previous</button>
						<button type="button" onclick="next(${page.nowPage<page.pageCount?page.nowPage+1:page.pageCount})" class="btn btn-success col-md-1">next</button>
						<button type="button" onclick="end()" class="btn btn-success col-md-1">END</button>
						<div class="form-group">
							当前页：<input type="text" name="nowPage" value="${page.nowPage}" />
							行数：<input type="text" name="limit" value="${page.limit}" />
							<input type="submit" class="btn btn-success" value="Serch">
						</div>
					</td>
				<tr>
			</table>
			</form>
			<a href="goInput"><button type="button" class="btn btn-success col-md-2">Save</button></a>
		</div>

	</div>

</body>
</html>
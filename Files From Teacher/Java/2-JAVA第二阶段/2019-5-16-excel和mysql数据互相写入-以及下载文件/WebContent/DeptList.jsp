<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function excelOut(){
		location.href="excelOut.do?time="+new Date().getTime();
	}
</script>
</head>
<body>
	<form action="excelIn.do" method="post" enctype="multipart/form-data">
		<input type="file" name="file" />
		<button>导入excel</button>
	</form>
	<button type="button" onclick="excelOut()">导出excel</button>
	
	<table width="800" border="1" align="center">
		<caption>部门管理</caption>
		<tr>
			<th>序号</th>
			<th>部门名称</th>
			<th>所在城市</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach var="dept" items="${depts }" varStatus="i">
			<tr>
				<th>${(pb.pageNum-1)*pb.pageRow+i.index+1 }</th>
				<th>${dept.dname }</th>
				<th>${dept.loc }</th>
				<th><a href="DeptServlet.do?method=getDept&deptno=${dept.deptno }">编辑</a></th>
				<th><a href="DeptServlet.do?method=delDept&deptno=${dept.deptno }">删除</a></th>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="5">
				<a href="DeptServlet.do?pageNum=1">首页</a>
				<a href="DeptServlet.do?pageNum=${pb.pageNum==1?1:pb.pageNum-1 }">上一页</a>
				<a href="DeptServlet.do?pageNum=${pb.pageNum==pb.countPage?pb.countPage:pb.pageNum+1 }">下一页</a>
				<a href="DeptServlet.do?pageNum=${pb.countPage }">末页</a>
			</th>
		</tr>
	</table>
	<a href="DeptAdd.jsp">添加部门</a>
</body>
</html>
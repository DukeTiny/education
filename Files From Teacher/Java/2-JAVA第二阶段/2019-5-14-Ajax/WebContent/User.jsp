<%@page import="com.woniu.bean.User"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册页面</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("form").hide();
		$("#editBtn").click(function(){
			$("form").hide();
			if($("#editBtn").text()=="编辑"){
				$.post("User.do",{"method":"update","uid":$("#uid").val(),"uname":$("#uname").val(),"upwd":$("#upwd").val(),"urole":$("#urole").val(),"ustate":$("#ustate").val()},function(data,status){
					showAll(data);
				});
			}else if($("#editBtn").text()=="新增"){
				$.post("User.do",{"method":"add","uid":$("#uid").val(),"uname":$("#uname").val(),"upwd":$("#upwd").val(),"urole":$("#urole").val(),"ustate":$("#ustate").val()},function(data,status){
					showAll(data);
				});
			}
		});
		function showAll(data){
			$("tbody").empty();
			var users = eval('('+data+')');
			$.each(users,function(index,user){
				var trObj = $("<tr></tr>");
				var tdObj1 = $("<td></td>");
				tdObj1.text(index+1);
				var tdObj2 = $("<td></td>");
				tdObj2.text(user.uname);
				var tdObj3 = $("<td></td>");
				tdObj3.text(user.upwd);
				var tdObj4 = $("<td></td>");
				tdObj4.text(user.urole);
				var tdObj5 = $("<td></td>");
				tdObj5.text(user.ustate);
				var tdObj6 = $("<td></td>");
				var btn1 = $("<button class='btn1'>编辑</button>");
				btn1.click(function(){
					$("form").show();
					$("#editBtn").html("编辑");
					$.post("User.do",{"method":"findOne","uid":user.uid},function(data,status){
						var u = eval('('+data+')');
						$("#uid").val(u.uid);
						$("#uname").val(u.uname);
						$("#upwd").val(u.upwd);
						$("#urole").val(u.urole);
						$("#ustate").val(u.ustate);
					});
				});
				tdObj6.append(btn1);
				var tdObj7 = $("<td></td>");
				var btn2 = $("<button class='btn2'>删除 </button>");
				tdObj7.append(btn2);
				btn2.click(function(){
					
				});
				trObj.append(tdObj1);
				trObj.append(tdObj2);
				trObj.append(tdObj3);
				trObj.append(tdObj4);
				trObj.append(tdObj5);
				trObj.append(tdObj6);
				trObj.append(tdObj7);
				$("tbody").append(trObj);
			});
		}
		$.post("User.do",{"method":"list"},function(data,status){
			showAll(data);
		});
		$("#addBtn").click(function(){
			$("form").show();
			//将数据清空
			$("#uid").val(u.uid);
			$("#uname").val(u.uname);
			$("#upwd").val(u.upwd);
			$("#urole").val(u.urole);
			$("#ustate").val(u.ustate);
			$("#editBtn").html("新增");
		});
	});
</script>
</head>
<body>
	<table width="800" border="1" align="center">
		<caption>用户管理</caption>
		<thead>
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>角色</th>
			<th>状态</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	<button type="button" id="addBtn">新增</button>
	<form action="" method="post">
	 <input type="hidden" name="uid" id="uid"/>
	  用户名:<input type="text" name="uname" id="uname" /><br>
	  密码:<input type="text" name="upwd" id="upwd" /><br>
	  角色:<input type="text" name="urole" id="urole" /><br>
	  状态:<input type="text" name="ustate" id="ustate" /><br>
	  <button type="button" id="editBtn">编辑</button>
	</form>
</body>
</html>
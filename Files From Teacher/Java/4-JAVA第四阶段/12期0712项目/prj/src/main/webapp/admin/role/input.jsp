<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
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

<link rel="stylesheet" href="<%=basePath%>css/demo.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.ztree.excheck-3.5.js"></script>

<SCRIPT type="text/javascript">
		<!--
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable:true,
					idKey: "id",
					pIdKey: "pid",
					rootPId: ""
				}
			}
		};

		var zNodes =${json};
		
		var code;
		
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			py = $("#py").attr("checked")? "p":"",
			sy = $("#sy").attr("checked")? "s":"",
			pn = $("#pn").attr("checked")? "p":"",
			sn = $("#sn").attr("checked")? "s":"",
			type = { "Y" : "ps", "N" : "ps" };
			zTree.setting.check.chkboxType = type;
			//showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
			$("#py").bind("change", setCheck);
			$("#sy").bind("change", setCheck);
			$("#pn").bind("change", setCheck);
			$("#sn").bind("change", setCheck);
			
			//在此处进行回填
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			
			<c:forEach items="${role.trees}" var="t">
			var node = zTree.getNodeByParam("id",${t.id});
			zTree.checkNode(node, true, false);
			</c:forEach>
			
			
		});
		//-->
		
		function dosave(){
			var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");  //ztree的Id  zTreeId

			var checkedNodes = zTreeObj.getCheckedNodes();
			var ids = "";
			for(var i=0;i<checkedNodes.length;i++){
				ids += checkedNodes[i].id;
				if(i<checkedNodes.length-1){
					ids += ",";
				}
			}
			$("input[name=ids]").val(ids);
			document.forms[0].submit();
		}
	</SCRIPT>
</head>
<body>
<div class="container">
<FORM METHOD=POST ACTION="${role==null?'save':'update'}">
<input type="hidden" name="rid" value="${role.rid }">
rname	<INPUT TYPE="text" NAME="rname" value="${role.rname }"><br>
<input type="hidden" name="ids">

请选择您需要的权限：

<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</div>
</div>
<INPUT TYPE="button" onclick="dosave()" value="${role==null?'save':'update'}">
</FORM>
</body>
</html>





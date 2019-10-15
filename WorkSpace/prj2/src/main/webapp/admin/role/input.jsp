<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%=basePath%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>ZTREE DEMO - Custom Icon</TITLE>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=basePath%>/css/demo.css" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery.ztree.excheck-3.5.js"></script>
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

	var zNodes =${trees}
	
	var code;
	
	function setCheck() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		py = $("#py").attr("checked")? "p":"",
		sy = $("#sy").attr("checked")? "s":"",
		pn = $("#pn").attr("checked")? "p":"",
		sn = $("#sn").attr("checked")? "s":"",
		type = { "Y":"ps", "N":""};
		/* zTree.setting.check.chkboxType = type; */
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

		zTree = $.fn.zTree.getZTreeObj("treeDemo");//treeDemo界面中加载ztree的div
		<c:forEach items="${role.trees}" var="rt">
			var node = zTree.getNodeByParam("id",${rt.id});
			zTree.checkNode(node,true,false);
		</c:forEach>
			
	});

	function saveRole(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var checkedNodes = zTree.getCheckedNodes();
		var ids = "";
		for( var i=0; i<checkedNodes.length; i++ ){
			ids += checkedNodes[i].id;
			if( i<checkedNodes.length ) {
				ids += ","
			}
		}
		
		$("input[name=ids]").val(ids);
		document.forms[0].submit()
	}
	
	//-->
	
	
    </SCRIPT>
  </HEAD>

<BODY>
<form method="post" action="${role==null?'save':'update'}">
<input type="hidden" name="ids" />
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</div>
角色名称：<input type="text" value="${role.name}" name="name" />
<button type="button" onclick="saveRole()">${role==null?"save":"update"}</button>
</form>

</BODY>
</HTML>
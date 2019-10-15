<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<TITLE>ZTREE DEMO - Custom Icon</TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=basePath%>/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<style>
		body {
			background-color: white;
			margin: 0;
			padding: 0;
			text-align: center;
		}
		div, p, table, th, td {
			list-style: none;
			margin: 0;
			padding: 0;
			color: #333;
			font-size: 12px;
			font-family: dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
		}
		
		#testIframe {
			margin-left: 10px;
		}
	</style>
	<script type="text/javascript"
		src="<%=basePath%>/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/js/jquery.ztree.core-3.5.js"></script>
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
	<script type="text/javascript" >

		function getTree(){
			$.ajax()
		}
		
	  <!--
		var zTree;
		var demoIframe;
	
		var setting = {
			view: {
				dblClickExpand: false,
				showLine: true,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable:true,
					idKey: "id",
					pIdKey: "pid",
					rootPId: ""
				}
			},
			callback: {
				beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("tree");
					if (treeNode.isParent) {
						zTree.expandNode(treeNode);
						return false;
					} else {
						demoIframe.attr("src",treeNode.file);
						return true;
					}
				}
			}
		};
	
		var zNodes =${json}; 
	
		$(document).ready(function(){
			var t = $("#tree");
			t = $.fn.zTree.init(t, setting, zNodes);
			demoIframe = $("#testIframe");
			demoIframe.bind("load", loadReady);
			var zTree = $.fn.zTree.getZTreeObj("tree");
			zTree.selectNode(zTree.getNodeByParam("id", 101));
	
		});
	
		function loadReady() {
			var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
			htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
			maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
			h = demoIframe.height() >= maxH ? minH:maxH ;
			if (h < 530) h = 530;
			demoIframe.height(h);
		}
	
	  //-->
    </SCRIPT>
  </HEAD>

<BODY>
	<div id="app">
	<TABLE border=0 height=600px align=left>
		<TR>
			<TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
				<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
			</TD>
			<TD width=1000px align=left valign=top><IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px SRC="core/standardData.html"></IFRAME></TD>
		</TR>
	</TABLE>
	</div>
</BODY>
</HTML>
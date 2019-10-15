大前端时代：

不用深入研究，直接猛用。

Js（后台数据的）
Jquery
LigerUI:
EasyUI:项目的后台内容
Vue:项目的前台内容

============================
前后端分离：

后端打JSON.返回JSON.不做任何形式的页面跳转。

前端不做任何提交，只做Ajax的请求。

============================
跨域：
1：
response.addHeader("Access-Control-Allow-Origin", "*");

2：服务器和客户端构建jsonp请求。


		$.ajaxSetup({
			  global: true,
			  type: "POST",
			  cache: false,
			  async: false
		});

		
		$.ajax({
			  url: "findAll",
			  success: function(html){
			    console.log("zsf");
			  }
		});

============================
$被占了怎么办？
	jQuery.noConflict();运行这个函数将变量$的控制权让渡给第一个实现它的那个库。

	jQuery.ajax({
			  url: "findAll",
			  success: function(html){
			    console.log("zsf");
			  }
		});
============================	

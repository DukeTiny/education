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

<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" id="app">

uname:<input type="text" name="uname" v-model="uname" >
action:<input type="text" name="action" v-model="action">
<button type="button" class="btn btn-primary" @click="show()">Go</button>
<table class="table table-striped">
  <tr>
  <td class="active">logid</td>
  <td class="success">uname</td>
  <td class="warning">action</td>
  <td class="warning">actiontime</td>
  <td class="danger">uid</td>
</tr>
<tr v-for="log in list">
  <td class="active">{{log.logid}}</td>
  <td class="success">{{log.uname }}</td>
  <td class="warning">{{log.action }}</td>
  <td class="danger">{{log.actiontime}}</td>
  <td class="danger">{{log.uid}}</td>
  </td>
</tr>
</table>
<table>
<tr>
  <td class="active"><button type="button" @click="first()" class="btn btn-primary">First</button></td>
  <td class="success"><button type="button" @click="next()" class="btn btn-primary">Next</button></td>
  <td class="success"><button type="button" @click="before()" class="btn btn-primary">Before</button></td>
  <td class="success"><button type="button" @click="last()" class="btn btn-primary">End</button></td>
  <td class="success">pageNow:<input type="text" size="1" v-model="page.pageNow" name="pageNow"></td>
  <td class="success">limit:<input type="text" size="1"  v-model="page.limit" name="limit"></td>
  <td class="success">共{{page.count}}条  共{{page.pageCount}}页</td>
  <td class="danger"><button @click="show()" type="submit" class="btn btn-primary">Go</button></td>
  </td>
</tr>
</table>

<a href="goInput"><button type="button" class="btn btn-primary">Save</button></a>
</div>
</body>
</html>
<script>
	Vue.http.options.emulateJSON=true;
	
	var app = new Vue({
	  el: '#app',
	  data: {
			list:'',
			page:'',
			log:'',
			pageNow:1,
			limit:10,
			uname:'',
			action:''
	  },
	  mounted:function(){
		  this.show();
	  },
	  methods:{
		  show:function(){
			  this.$http.post('find',{pageNow:this.pageNow,limit:this.limit,uname:this.uname,action:this.action}).then(function(res){
              	app.list=res.body.list;
              	app.page=res.body.page;
              	this.uname=res.body.log.uname;
              	this.action=res.body.log.action;
              },function(){
                  console.log('请求失败处理');
              });
		  },
		  first:function(){
			  this.pageNow = 1;
			  this.show();
		  },
		  next:function(){
			  this.pageNow = this.pageNow+1;
			  this.show();
		  },
		  before:function(){
			  this.pageNow = this.pageNow-1;
			  this.show();
		  },
		  last:function(){
			  this.pageNow = this.page.pageCount;
			  this.show();
		  }
	  }	
	})
</script>
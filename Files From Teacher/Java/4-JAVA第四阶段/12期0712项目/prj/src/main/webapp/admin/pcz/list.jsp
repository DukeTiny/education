<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>

</head>
<body>
<div id="app">

p
<select @change="fillCity($event.target.selectedIndex)">
	<option v-for="p in ps" :value="p.pid">{{p.pname}}</option>
</select>

c
<select @change="fillZone($event.target.selectedIndex)">
	<option v-for="c in cs" :value="c.cid">{{c.cname}}</option>
</select>

z
<select>
	<option v-for="z in zs" :value="z.zid">{{z.zname}}</option>
</select>

</div>

</body>
</html>

<script>
	Vue.http.options.emulateJSON=true;
	
	var app = new Vue({
	  el: '#app',
	  data: {
			ps:'',
			cs:'',
			zs:''
	  },
	  mounted:function(){
		  this.show();
	  },
	  methods:{
		  show:function(){
			  this.$http.post('findAll',{}).then(function(res){
              	app.ps=res.body;
              	this.fillCity(0);
              },function(){
                  console.log('请求失败处理');
              });
		  },
		  fillCity:function(pindex){
			  this.cs = this.ps[pindex].citys;
			  this.fillZone(0);
		  },
		  fillZone:function(cindex){
			  this.zs = this.cs[cindex].zones;
		  }
		 
	  }	
	})
</script>
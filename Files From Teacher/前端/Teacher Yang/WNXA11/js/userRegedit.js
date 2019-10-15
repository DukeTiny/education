function checkValue(){
	//获取元素的值
	var uname = document.getElementById("uname").value;
	var upass = document.getElementById("upass").value;
	var conPass = document.getElementById("conPass").value;
	//通过name的值获取数组
	var sexes = document.getElementsByName("sex");
	var sex = "";
	for(var i=0;i<sexes.length;i++){
		if(sexes[i].checked == true){
			sex = sexes[i].value;
		}
	}
//	alert(sex);
	//获取兴趣爱好
	var fs = new Array();
	var faves = document.getElementsByName("fav");
	for(var i=0;i<faves.length;i++){
		if(faves[i].checked == true){
			fs.push(faves[i].value);
		}
	}
	
	//获取被选中的城市
	var cityName = "";
	var cities = document.getElementsByName("city");
	for(var i=0;i<cities.length;i++){
		if(cities[i].selected == true){
			cityName = cities[i].value;
		}
	}
	
	//获取联系电话
	var phone = document.getElementById("phone").value;
	//获取邮箱
	var email = document.getElementById("email").value;
	
	//对以上内容进行验证
	
	if(uname == "" || upass == "" || conPass == ""){
		alert("用户名或密码不能为空");
		window.location.reload();
		return;
	}
	
	if(uname.length<6){
		alert("用户名不能少于6位");
		window.location.reload();
		return;
	}
	
	if(upass.length<6 || conPass.length<6){
		alert("密码长度不能少于6位");
		window.location.reload();
		return;
	}
	
	if(upass != conPass){
		alert("原密码和确认密码不一致");
		window.location.reload();
		return;
	}
	//检查电话长度为11并且是数字
	if(phone.length != 11 || isNaN(phone)){
		alert("电话输入有误");
		window.location.reload();
		return;
	}
	document.getElementById('un').innerHTML = uname;
	//向fs的div中写入数组元素
	var favStr = "";
	for(var i=0;i<fs.length;i++){
		favStr += fs[i]+";";
	}
	document.getElementById("uf").innerHTML = favStr;
}

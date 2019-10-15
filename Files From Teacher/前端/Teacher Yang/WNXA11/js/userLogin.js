
function userLogin() {

	var users = ["abc", "xyz", "qwe", "zxc"];
	//在页面上获取账号的值和密码的值
	var upass = document.getElementById("upass").value;
	var uname = document.getElementById("uname").value;
	var index = checkUserName(uname);
	if(index < users.length) {
		checkUserPass(upass,index);
	} else {
		alert("用户名不匹配，请重新获取");
		window.location.reload();
	}

}

function checkUserName(uname) {
	var users = ["abc", "xyz", "qwe", "zxc"];
	for(var i = 0; i < users.length; i++) {
		if(users[i] == uname) {
			break;
		}
	}
	return i;
}

function checkUserPass(upass,index) {
	var passes = ["123", "223", "323", "423"];
	if(passes[index] == upass){
		alert("密码输入正确");
		window.location.href="mainMenu.html";
	}else{
		alert("密码输入不正确，请重新输入");
		window.location.reload();
	}
}
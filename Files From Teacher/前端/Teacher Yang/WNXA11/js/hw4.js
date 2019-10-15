var accounts = ["qiang", "admin", "woniuxy", "hello"];
var passwords = ["1234", "2234", "3234", "4234"];

var flag = false;
while(true) {
	var account = prompt("请输入您要注册的账号名：");
	for(var i = 0; i < accounts.length; i++) {
		if(accounts[i] == account) {
			flag = true;
			break;
		}
	}
	if(flag) {
		alert("该账号已被注册，请重新输入账号");
	} else {
		alert("恭喜您账号未被使用，可以注册");
		accounts.push(account);
		break;
	}
}

alert(accounts);

//var accErrCount = 0,
//	passErrCount = 0;
//var isAccErr = false;
//while(true) {
//	if(accErrCount < 3) {
//		var flag = false;
//		var account = prompt("请输入您的账号");
//		for(var i = 0; i < accounts.length; i++) {
//			if(accounts[i] == account) {
//				flag = true;
//				break;
//			}
//		}
//		if(flag) {
//			alert("账号输入正确");
//			break;
//		} else {
//			accErrCount++;
//			alert('账号输入错误，请重新输入');
//		}
//	} else {
//		alert("账号输入错误次数过多，登录失败");
//		isAccErr = true;
//		break;
//	}
//}
//
//if(isAccErr) {
//	alert("账号输入错误次数过多，无法输入密码");
//} else {
//	while(true) {
//		if(passErrCount<3) {
//			var pass = prompt('请输入密码');
//			if(pass == passwords[i]) {
//				alert('密码输入正确');
//				break;
//			} else {
//				passErrCount++;
//				alert('密码错误，请重新输入');
//			}
//		}else{
//			alert("密码错误次数过多，退出登录");
//			break;
//		}
//	}
//}
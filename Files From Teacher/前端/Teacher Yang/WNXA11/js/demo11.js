//welcomeLogin(); //显示欢迎登录页面
//login();
////checkAccount();//检查账号
////checkPassword();//检查密码
//showMainMenu();//显示主菜单



function inputNumber() {
	//var x, y, z;//局部变量
	x = parseInt(prompt("请输入第一个整数"));
	y = parseInt(prompt("请输入第二个整数"));
	z = parseInt(prompt("请输入第三个整数"));

}

function cacl() {

	sum = x + y + z;
	avg = sum / 3;
	mul = x * y * z;
}

function outputResult() {
	document.write("三个数的和是：" + sum + "<br />");
	document.write("三个数的平均值是：" + avg + "<br />");
	document.write("三个数的乘积是：" + mul + "<br />");
}




inputNumber();
alert(x);
cacl();
outputResult();
//function welcomeLogin() { //定义函数
//	document.write("*******************<br />");
//	document.write("***欢迎登录***<br />");
//	document.write("******************<br />");
//}
//
//function login(){
//	checkAccount();
//	checkPassword();
//}
//
//
//function checkAccount() {
//	while(true) {
//		var account = prompt("请输入您的账号");
//		if(account == "admin") {
//			alert("账号输入正确");
//			break;
//		} else {
//			alert("账号输入错误，请重新输入");
//		}
//	}
//}
//
//function checkPassword() {
//	while(true) {
//		var pass = prompt("请输入您的密码");
//		if(pass == "123") {
//			alert("密码输入正确，欢迎进入系统");
//			break;
//		} else {
//			alert("账号输入错误，请重新输入");
//		}
//	}
//}
//
//function showMainMenu() {
//	document.write("*****************<br />");
//	document.write("*1.存款<br />");
//	document.write("*2.取款<br />");
//	document.write("*3.查询余额<br />");
//	document.write("*4.转账<br />");
//	document.write("*****************<br />");
//}
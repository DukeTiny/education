//var errCount = 0;
//
//while(true) {
//	if(errCount<3) {
//		var account = prompt("请输入账号");
//		var pass = prompt("请输入密码");
//		if(account == "administrator" && pass == "123456") {
//			alert("输入正确");
//			break;
//		} else {
//			alert("输入错误，请重新输入");
//			errCount++;
//		}
//	}else{
//		alert("输入错误次数过多，退出登录");
//		break;
//	}
//}

//var accErrCount = 0,passErrCount = 0;
//while(true) {
//	if(accErrCount < 3) {
//		var account = prompt("请输入账号");
//		if(account == "administrator") {
//			alert("账号输入正确");
//
//			while(true) {
//				if(passErrCount<3){
//					var pass = prompt("请输入密码");
//				if(pass == "123456") {
//					alert("密码输入正确");
//					break;
//				} else {
//					alert("密码输入错误，请重新输入");
//					passErrCount++;
//				}
//				}else{
//					alert("密码输入错误次数过多，退出登录");
//					break;
//				}
//			}
//			break;
//		} else {
//			alert("账号输入错误，请重新输入");
//			accErrCount++;
//		}
//	} else {
//		alert("账号输入错误次数过多，退出登录");
//		break;
//	}
//}

//var passErrCount = 0;
//while(true) {
//	if(passErrCount<3){
//		var pass = prompt("请输入密码");
//	if(pass == "123456") {
//		alert("密码输入正确");
//		break;
//	} else {
//		alert("密码输入错误，请重新输入");
//		passErrCount++;
//	}
//	}else{
//		alert("密码输入错误次数过多，退出登录");
//		break;
//	}
//}

//var num = parseInt(prompt("请输入一个大于100的整数："));
//var flag = true; //使用标记flag，假设这个数字开始是质数
//if(num % 2 != 0) {
//	for(var i = 2; i < parseInt(num / 2); i++) {
//		if(num % i == 0) {
//			flag = false;
//			break;
//		}
//	}
//} else {
//	alert(num + "不是质数");
//}
//
//if(flag) {
//	alert(num + "是质数");
//} else {
//	alert(num + '不是质数');
//}

//从键盘输入一个整数，输出所有2-该整数之间的质数
//
//var num = parseInt(prompt("请输入一个整数："));
//for(var i=2;i<=num;i++){
//	var flag = true;
//	for(var j=2;j<i;j++){
//		if(i%j == 0){
//			flag = false;
//			break;
//		}
//	}
//	if(flag){
//		document.write(i + "是质数<br />");
//	}else{
//		document.write(i + "不是质数<br />");
//	}
//}

//从键盘输入一个字符，判断字符的类型
//输入字符串
//var numCount=0,bigCount=0,smallCount=0,otherCount=0;
//var str = prompt("请输入一串字符");
//alert(str.length);
//for(var i = 0; i < str.length; i++) {
//	var code = str.charCodeAt(i);
//	if(code >= 48 && code <= 57) {
//		numCount++;
//	} else if(code >= 65 && code <= 90) {
//		bigCount++;
//	} else if(code >= 97 && code <= 122) {
//		smallCount++;
//	} else {
//		otherCount++;
//	}
//}
//
//document.write("数字有"+numCount+"个<br />");
//document.write("大写字母有"+bigCount+"个<br />");
//document.write("小写字母有"+smallCount+"个<br />");
//document.write("其它字符有"+otherCount+"个<br />");
//var code = c.charCodeAt(0)
//if(code>=48 && code<=57){
//	alert(c+"是一个数字");
//}else if(code>=65 && code<=90){
//	alert(c+"是一个大写字母");
//}else if(code>=97 && code<=122){
//	alert(c+"是一个小写字母");
//}else{
//	alert(c+"是其它符号");
//}

//Math.random()生成一个0-1之间的随机数,不包括0和1

var trueNumber = parseInt(Math.random() * 1000) + 1;

var count = 0;
while(true) {
	if(count < 8) {
		var num = parseInt(prompt("请输入您猜测的数字"));
		if(num > trueNumber) {
			alert("大了");
			count++;
		} else if(num < trueNumber) {
			alert("小了");
			count++;
		} else {
			alert("恭喜您猜对了");
			count++;
			alert(trueNumber);
			alert("您一共猜测了" + count + "次");
			break;
		}
	} else {
		alert('over');
		break;
	}
}
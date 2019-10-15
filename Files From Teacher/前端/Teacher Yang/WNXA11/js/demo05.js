//水仙花数

//for(var num=100;num<=999;num++){
//	var x = parseInt(num/100);//百位数字
//	//153%100 ===53 parseInt(53/10)5
//	var y = parseInt((num%100)/10);//十位数字
//	//153%10 3
//	var z = num%10;//个位数字
//	if(x*x*x+y*y*y+z*z*z == num){
//		document.write("水仙花数是："+num+"<br />");
//	}
//}

//for(var i=1;i<=9;i++){
//	for(var j=0;j<=9;j++){
//		for(var k=0;k<=9;k++){
//			if(i*100+j*10+k == (i*i*i + j*j*j + k*k*k)){
//				document.write("水仙花数是："+(i*100+j*10+k)+"<br />");
//			}
//		}
//	}
//}

//var a = parseInt(prompt("请输入底数"));
//var b = parseInt(prompt("请输入指数"));
//var result = 1;
//
//if(a != 0) {
//	if(b > 0) {
//		for(var i = 0; i < b; i++) {
//			result = result * a;
//		}
//	} else if(b < 0) {
//		b = 0-b;
//		for(var i = 0; i < b; i++) {
//			result = result * a;
//		}
//		result = 1/result;
//	} else {
//		result = 1;
//	}
//} else {
//	alert("底数不能为0");
//}
//
//alert(result);

//var count = 0;
//for(var i=0;i<=5;i++){
//	for(var j=0;j<=7;j++){
//		for(var k=0;k<=9;k++){
//			if((i+k+j) == 12){	
//				count++;
//				document.write("第"+count+"种情况：红球有"+i+"个，黑球有"+j+"个，白球有"+k+"个<br />")
//				break;
//			}
//		}
//	}
//}
//document.write("总共有"+count+"种组合情况");


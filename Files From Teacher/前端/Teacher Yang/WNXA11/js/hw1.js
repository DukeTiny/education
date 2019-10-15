//var a = prompt("请输入第一个值：");
//var b = prompt("请输入第二个值：");
//var c = prompt("请输入第三个值：");
//document.write("交换前：a="+a+"&nbsp;&nbsp;b="+b+"&nbsp;&nbsp;c="+c+"<br />");
//var temp = a;
//console.log("temp="+temp);
//a = b;
//b = c;
//c = temp;
//document.write("交换后：a="+a+"&nbsp;&nbsp;b="+b+"&nbsp;&nbsp;c="+c+"<br />");

//var age = prompt("请输入您的年龄：");
//if(isNaN(age)){
//	alert("输入不正确，请输入数字");
//}else{
//	alert("输入的是数字");
//	var newAge = parseInt(age);
//	alert(newAge);
//	if(newAge>0 && newAge<150){
//		alert("输入正确");
//		if(newAge>60){
//			alert("老年人");
//		}else if(newAge>=20 && newAge<=40){
//			alert("青年人");
//		}else if(newAge<=10){
//			alert("孩子");
//		}else{
//			alert("年龄不在判断的范围内");
//		}
//	}else{
//		alert("年龄应该在0-150之间");
//	}
//}

//var year = parseInt(prompt("请输入年份"));
//if( ((year%4 == 0) && (year%100 != 0))|| (year%400 == 0)){
//	alert("是闰年");
//}else{
//	alert("不是闰年");
//}

var a,b,c;

a = parseInt(prompt("请输入第一条边长："));
b = parseInt(prompt("请输入第二条边长："));
c = parseInt(prompt("请输入第三条边长："));

if((a+b)>c && (a+c)>b && (b+c)>a){
	alert("是三角形");
	if(a==b && b==c){
		alert("等边三角形");
	} else if(a==b || a==c || b==c){
		alert("等腰三角形");
	} else if(a*a+b*b==c*c || b*b+c*c==a*a || a*a+c*c == b*b){
		alert("直角三角形");
	} else{
		alert("一般三角形");
	}
	
}else{
	alert("不是三角形");
}

//var i = 0;//计数器
//while(i<100){
//	document.write("第"+(i+1)+"天上学<br />");
//	document.write("第"+(i+1)+"天上课<br />");
//	document.write("第"+(i+1)+"天上晚自习<br />");
//	document.write("第"+(i+1)+"天回家<br />");
//	i++;
//}
//document.write("结束");

//while(true) {
//	var account = prompt("请输入账号：");
//	var pass = prompt("请输入密码");
//	if(account == "administrator" && pass == "123456") {
//		alert("账号密码输入正确");
//		break;
//	} else {
//		alert("账号密码输入错误，请重新输入");
//	}
//}

//从1开始加到1000的总和
//var max = parseInt(prompt("请输入最大值"));
//var sum = 0;
////if(max%2 == 0){
////	sum = (1+max)*(max/2);
////}else{
////	sum = (1+max-1)*((max-1)/2) + max;
////}
//
//var i = 1;
//while(i<=max){
//	sum += i;
//	i++;
//}
//alert(sum);

//从1开始到max的奇数和

//
//var max = parseInt(prompt("请输入最大值"));
//var sum = 0;
//for(var i=1;i<=max;i+=2){
//	sum += i;
//}
//var i = 1;
//while(i<=max){
//	sum += i;	
//	i += 2;
//}
//alert(sum);

//var i=0;
//while(i<10){
//	document.write("第"+(i+1)+"次说：good good study,day day up<br />");
//	i++;
//}

//for(var i=0;true;i++){
//	document.write("第"+(i+1)+"次说：good good study,day day up<br />");
//}

//var num = parseInt(prompt("请输入数字"));
//for(var i=0,j=num;i<=num;i++,j--){
//	document.write(i+"+"+j+"="+num+"<br />");
//}

//
//1*1=1
//1*2=2 2*2=4
//1*3=3 2*3=6 3*3=9
//
//*
//**
//***
//****
//*****
//******
//*******
//********
//
//*********
//*********
//*********
//*********
//*********
//*********
//*********
//*********
//*********


//for(var i = 0; i < 5; i++) {
//	for(var j=0; j <5 ; j++){
//		document.write("*&nbsp;");
//	}
//	document.write("<br />");
//}

//document.write("*&nbsp;");
//document.write("<br />");
//document.write("*&nbsp;");
//document.write("*&nbsp;");
//document.write("<br />");
//document.write("*&nbsp;");
//document.write("*&nbsp;");
//document.write("*&nbsp;");
//document.write("<br />");

//for(var i=1;i<=9;i++){
//	for(var j=1;j<=i;j++){
//		document.write("*&nbsp;");
//	}
//	document.write("<br />");
//}

for(var i=1;i<=9;i++){
	for(var j=1;j<=i;j++){
		if(i*j<10){
			document.write(j+"*"+i+"=&nbsp;&nbsp;"+i*j+"&nbsp;&nbsp;");
		}else{
			document.write(j+"*"+i+"="+i*j+"&nbsp;&nbsp;");
		}
		
	}
	document.write("<br />");
}


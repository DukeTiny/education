//有一个数组，名字叫names
var names = new Array();
names.push("孙悟空");
names.push("猪悟能");
names.push("沙悟净");
alert(names);
//var age = [2600,2900,3800];
//var names = ["孙悟空","猪悟能","沙悟净"];
//var person = [age,names];
//var names = new Array();
//////给数组添加元素
//names[0] = "hello";
//names[5] = "world";
//names[1] = 100;
//names[100000] = 10;
////取出下标处的元素
//alert(names[100000]);
//获取数组的长度
//alert(names.length);
//var stuNames = new Array();
//var i = 0;
//while(true) {
//	stuNames[i] = prompt("请输入第" + (i + 1) + "位同学的姓名：");
//	var choice = prompt("要继续输入下一位同学的姓名吗?(y/n)");
//	if(choice == "y"){
//		i++;
//		continue;		
//	}else{
//		break;
//	}
//}

//输出数组中的所有元素

//for(var i = 0; i < stuNames.length+1; i++) {
//	stuNames[i] = prompt("请输入第" + (i + 1) + "位同学的姓名：");
//	var choice = prompt("要继续输入下一位同学的姓名吗?(y/n)");
//	if(choice == "y") {
//		continue;
//	} else {
//		break;
//	}
//}
//
//for(var i=0;i<stuNames.length;i++){
//	document.write("第"+(i+1)+"位同学的姓名是："+stuNames[i]+"<br />");
//}

//求数组中数字的最大（小）值
//var scores = [89,82,96,77,64,99,81];
//var min = scores[0];
//for(var i=1;i<scores.length;i++){
//	if(scores[i]<min){
//		min = scores[i];
//	}
//}
//alert("最小值是："+min);

//var scores = [89,82,96,77,64,77,99,81,10];
//var tempscores;
//tempscores = scores;
//for(var i=0;i<tempscores.length;i++){
//	document.write(tempscores[i]+"&nbsp;&nbsp;");
//}
//倒序输出
//for(var i=scores.length-1;i>=0;i--){
//	document.write(scores[i]+"&nbsp;&nbsp;");
//}

//元素倒置

//for(var i=0;i<parseInt(scores.length/2);i++){
//	var temp = scores[i];
//	scores[i] = scores[scores.length-1-i];
//	scores[scores.length-1-i] = temp;
//}
//
//
////scores.reverse();
//for(var i=0;i<scores.length;i++){
//	document.write(scores[i]+"&nbsp;&nbsp;");
//}
//scores.pop();
//for(var i=0;i<scores.length;i++){
//	document.write(scores[i]+"&nbsp;&nbsp;");
//}

//var flag = false;
//var score = parseInt(prompt("请输入您要删除的成绩："));
//for(var i=0;i<scores.length;i++){
//	if(scores[i] == score){
//		for(var j=i;j<scores.length-1;j++){
//			scores[j] = scores[j+1];
//		}
//		scores.pop();
//		flag = true;
//		break;
//	}
//}
//
//if(flag){
//	alert("删除成功，删除后的成绩表是：");
//	for(var i=0;i<scores.length;i++){
//	document.write(scores[i]+"&nbsp;&nbsp;");
//	}
//}else{
//	alert("没有找到该成绩");
//var flag = false;//假定没有重复
//var scores1 = [89,82,96,77,64,99,10];
//
//var scores2 = [3,4,5,9,4,7];
//
//for(var i=0;i<scores1.length;i++){
//	for(var j=0;j<scores2.length;j++){
//		if(scores1[i] == scores2[j]){
//			flag = true;
//		}
//	}
//}
//for(var i=0;i<scores.length-1;i++){
//	for(var j=i+1;j<scores.length;j++){
//		if(scores[i] == scores[j]){
//			alert("重复数字是："+scores[j]);
//			flag = true;
//		}
//	}
//}
//
//if(flag){
//	alert("数组中有重复数据");
//}else{
//	alert("没有重复数据");
//}
//var scores = [89,82,96,77,64,99,10];
////scores.sort();
////scores.reverse();
////for(var i=0;i<scores.length;i++){
////	document.write(scores[i]+"&nbsp;&nbsp;");
////}
//
//for(var i=0;i<scores.length-1;i++){
//	for(var j=0;j<scores.length-i-1;j++){
//		if(scores[j]<scores[j+1]){
//			 var temp = scores[j];
//			 scores[j] = scores[j+1];
//			 scores[j+1] = temp;
//		}
//	}
//}
//
//for(var i=0;i<scores.length;i++){
//	document.write(scores[i]+"&nbsp;&nbsp;");
//}
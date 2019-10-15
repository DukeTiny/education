//定义一个空数组
var scores = new Array();
//给数组赋值
var i = 0;
while(true) {
	scores[i] = prompt("请输入第" + (i + 1) + "位同学的成绩：");
	var choice = prompt("要继续输入下一位同学的成绩吗?(y/n)");
	if(choice == "y") {
		i++;
		continue;
	} else {
		break;
	}
}
//输出数组的元素
for(var i = 0; i < scores.length; i++) {
	document.write("第" + (i + 1) + "位同学的成绩是：" + scores[i] + "<br />");
}
//求最高成绩
var max = scores[0];
for(var i = 1; i < scores.length; i++) {
	if(scores[i] > max) {
		max = scores[i];
	}
}
alert("最大值是：" + max);
//倒序输出
for(var i = scores.length - 1; i >= 0; i--) {
	document.write(scores[i] + "&nbsp;&nbsp;");
}
//数组元素倒置
for(var i = 0; i < parseInt(scores.length / 2); i++) {
	var temp = scores[i];
	scores[i] = scores[scores.length - 1 - i];
	scores[scores.length - 1 - i] = temp;
}
//输出倒置后的数组元素
for(var i = 0; i < scores.length; i++) {
	document.write("第" + (i + 1) + "位同学的成绩是：" + scores[i] + "<br />");
}
//删除指定的元素
var flag = false;
var score = parseInt(prompt("请输入您要删除的成绩："));
for(var i = 0; i < scores.length; i++) {
	if(scores[i] == score) {
		for(var j = i; j < scores.length - 1; j++) {
			scores[j] = scores[j + 1];
		}
		scores.pop();
		flag = true;
		break;
	}
}

//输出删除后的数组的元素
if(flag) {
	alert("删除成功，删除后的成绩表是：");
	for(var i = 0; i < scores.length; i++) {
		document.write(scores[i] + "&nbsp;&nbsp;");
	}
} else {
	alert("没有找到该成绩");
}

//判断当前数组中是否有重复元素
var isReapte = false;
for(var i = 0; i < scores.length - 1; i++) {
	for(var j = i + 1; j < scores.length; j++) {
		if(scores[i] == scores[j]) {
			alert("重复数字是：" + scores[j]);
			isReapte = true;
		}
	}
}

if(isReapte) {
	alert("数组中有重复数据");
} else {
	alert("没有重复数据");
}

//冒泡排序，从大到小进行排序
for(var i = 0; i < scores.length - 1; i++) {
	for(var j = 0; j < scores.length - i - 1; j++) {
		if(scores[j] < scores[j + 1]) {
			var temp = scores[j];
			scores[j] = scores[j + 1];
			scores[j + 1] = temp;
		}
	}
}
//排序完成后的输出
for(var i = 0; i < scores.length; i++) {
	document.write(scores[i] + "&nbsp;&nbsp;");
}
//1.代码冗余；2.结构混乱。需要使用函数
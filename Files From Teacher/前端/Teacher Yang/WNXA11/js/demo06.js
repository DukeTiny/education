while(true) {
	var sname = prompt("请输入您的姓名");
	alert("您的姓名是：" + sname);
	var choice = prompt('需要继续输入其它姓名吗？（y/n）');
	if(choice == "y") {
		continue;//继续重新开始
		alert("您正在继续输入。。。");
	}else{
		break;
	}
}

//do {
//	var sname = prompt("请输入您的姓名");
//	alert("您的姓名是：" + sname);
//	var choice = prompt('需要继续输入其它姓名吗？（y/n）');
//} while (choice == "y")

//for(var i=0;i<10;i++){
//	alert("正在跑第"+(i+1)+"圈。。。。");
//	var isCon = prompt("还能继续跑吗？");
//	if(isCon == "y"){
//		continue;
//	}else{
//		alert("跑不动，退出");
//		break;
//	}
//	alert("已经跑完了第"+(i+1)+"圈");
//}





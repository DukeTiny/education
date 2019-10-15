var rank = parseInt(prompt("请输入您比赛的名次"));

//if(rank == 1){
//	alert("第一名奖励10000元");
//}else if(rank == 2){
//	alert("第二名奖励5000元");
//}else if(rank == 3){
//	alert("第三名奖励2000元");
//}else if(rank == 4){
//	alert("第四名奖励500元");
//}else if(rank == 5){
//	alert("第五名奖励100元");
//}else{
//	alert("没有奖励");
//}
switch (rank){
	case 1:
		alert("第一名奖励10000元");
		break;
	case 2:
		alert("第二名奖励5000元");
		break;
	case 3:
		alert("第三名奖励2000元");
		break;
	case 4:
		alert("第四名奖励500元");
		break;
	case 5:
		alert("第五名奖励100元");
		break;
	default:
		alert("没有奖励");
		break;
}




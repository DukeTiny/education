//显示当前的系统时间： xxxx年xx月xx日 xx:xx:xx 星期x

//获取时间对象
var date = new Date();
//获取年
var year = date.getFullYear();
//获取月.月份从0开始
var month = date.getMonth()+1;
if(month<10){
	month = "0"+month;
}
//获取日期
var day = date.getDate();
if(day<10){
	day = "0"+day;
}
//获取小时
var hour = date.getHours();
if(hour<12){
	if(hour<10){
		hour = "上午0"+hour;
	}else{
		hour = "上午"+hour;
	}
}else{
	hour = hour - 12;
	if(hour<10){
		hour = "下午0"+hour;
	}else{
		hour = "下午"+hour;
	}
}
//获取分钟
var minute = date.getMinutes();
if(minute<10){
	minute = "0"+minute;
}
//获取秒
var second = date.getSeconds();
if(second<10){
	second = "0"+second;
}
//获取星期
var week = date.getDay();
switch(week){
	case 1:
		week = "一";
	break;
	case 2:
		week = "二";
	break;
	case 3:
		week = "三";
	break;
	case 4:
		week = "四";
	break;
	case 5:
		week = "五";
	break;
	case 6:
		week = "六";
	break;
	case 0:
		week = "日";
	break;
	default:
	break;
}
document.write("<h2 align='center'><font color='red'>"+year+"年"+month+"月"+day+"日&nbsp;&nbsp;"+
hour+":"+minute+":"+second+"&nbsp;&nbsp;星期"+week+"</font></h2>");


//function getValue(){
//	var firstNumber = document.getElementById("first").value;
//	var numA = parseInt(firstNumber);
//}

function getElementValue(){
	var firstNumber = document.getElementById("first").value;
	var numA = parseInt(firstNumber);
	var secondNumber = document.getElementById("second").value;
	var numB = parseInt(secondNumber);
	var sym = document.getElementById("symbol").value;
	//将获取的值组织成数组
	var elementValues = [numA,numB,sym];
	return elementValues;
}

function getResult(elementValues){
	var result = 0;
	switch(elementValues[2]) {
		case "+":
			result = elementValues[0] + elementValues[1];
			break;
		case "-":
			result = elementValues[0] - elementValues[1];
			break;
		case "*":
			result = elementValues[0] * elementValues[1];
			break;
		case "/":
			result = elementValues[0] / elementValues[1];
			break;
		default:
			alert("运算符输入错误");
			break;
	}
	return result;
	
}

function inputResult(result){//形式上的参数 形参
	document.getElementById("result").innerHTML = result;
}

function cacl() {
	var elementValues = getElementValue();
	var result = getResult(elementValues);
	inputResult(result);//实际上的参数 实参
//	alert(result);
//	alert("运算结果是："+result);
	
}
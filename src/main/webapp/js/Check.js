
function isEmpty(input) {
	return (!input.value);
}

function atLeastLetter(input, len) {
	return (input.value.length < len);
}

function isNotNumber(input) {
	return isNaN(input.value);
}

// jsp 페이지 예외처리 구문에서 100/10/1의 자릿수를 각각 분할하여 같은 값인지 확인해봄
// 같은 값이 있으면 true, 없으면 false
function isSameNumber(input){
	
	let a = parseInt(input.value/100);
	let b = parseInt((input.value%100)/10);
	let c = parseInt(input.value%10);
	console.log(a,b,c);
	
	if(a==b){
		return true;
	} else if(b==c){
		return true;
	} else if(a==c){
		return true;
	} else{
		return false;
	}
	
}
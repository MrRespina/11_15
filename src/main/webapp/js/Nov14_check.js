// Nov14_check.js

function bmiCheck() {
	// alert('connected')
	let nameBox = document.bmiForm.name;
	let heightBox = document.bmiForm.height;
	let weightBox = document.bmiForm.weight;
	let photoBox = document.bmiForm.photo;
	
	if(isEmpty(nameBox) || atLeastLetter(nameBox, 2)) {
		alert('Oops! 이름 다시 확인!');
		nameBox.value="";
		nameBox.focus();
		return false;
	} else if(isEmpty(heightBox) || atLeastLetter(heightBox, 3) || isNotNumber(heightBox)) {
		alert('Oops! 키 다시 확인!');
		heightBox.value='';
		heightBox.focus();
		return false;
	} else if(isEmpty(weightBox) || atLeastLetter(weightBox, 2) || isNotNumber(weightBox)) {
		alert('Oops! 몸무게 다시 확인!');
		weightBox.value="";
		weightBox.focus();
		return false;
	} else if(isEmpty(photoBox) || (isNotType(photoBox, 'gif') && 
						isNotType(photoBox, 'png') && isNotType(photoBox, 'jpg'))) {
		alert('Oops! 사진 다시 확인');
		photoBox.value='';
		photoBox.focus();
		return false;			
	}
	return true;	
}
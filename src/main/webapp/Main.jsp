<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구 테스트?</title>
<link rel="stylesheet" href="css/Baseball.css">

<script type="text/javascript" src="js/Check.js"></script>
<script type="text/javascript">
	function checkVal() {

		let num = document.formMain.number;
		let endNum = document.getElementById('endNum').innerText;
		// 첫번째로 진행 상황이 '종료'일 경우 아예 다시 실행하지 못하게끔 함.
		// 그 이후 예외 처리
		if (endNum == '종료') {
			alert('게임이 끝났습니다!\n');
			return false;
		} else if (isEmpty(num)) {
			alert('필수 항목을 입력해주세요!');
			num.focus();
			num.value = "";
			return false;
		} else if (isNotNumber(num)) {
			alert('숫자를 입력해주세요!');
			num.focus();
			num.value = "";
			return false;
		} else if (atLeastLetter(num, 3)) {
			alert('숫자는 3자리 수로 입력해주세요!');
			num.focus();
			num.value = "";
			return false;
		} else if (isSameNumber(num)) {
			alert('3자리에 각각 다른 숫자를 입력해주세요!');
			num.focus();
			num.value = "";
			return false;
		}

		return true;

	}
</script>

</head>
<body>
	<form name="formMain" action="HomeController"
		onsubmit="return checkVal();" method="post">
		<table id="mainT" border="1">
			<tr>
				<td id="mainTd" colspan="2">야구 게임!</td>
			</tr>
			<tr>
				<td class="subTd">숫자 입력</td>
				<td><input maxlength="3" name="number"
					placeholder="3자릿수,필수,중복X"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id="btn">시작!</button>
				</td>
			</tr>
			<tr>
				<td class="subTd" colspan="2" align="center">당신의 입력<br>
					${a }&nbsp;${b }&nbsp;${c }
				</td>
			</tr>
			<tr>
				<td class="subTd" colspan="2" align="center">결과<br>
					${strike } S&nbsp;&nbsp;${ball } B<br> ${count }회 도전했습니다.
				</td>
			</tr>
			<!-- 정답 확인용, hidden 클래스는 처음 HomeController에서 만들어졌던 Random값을 저장하는 용도로만 사용.(보이지 않음.)-->
			<tr>
				<td name="randNum" class="hidden" colspan="2" align="center"
					style="color: white;">숨겨진 정답 ${result }</td>
			</tr>
			<!-- 진행이 종료되면,endgame에 처음에 생성됐던 Random 값의 결과를 보여줌. -->
			<tr>
				<td id="endNum" class="end" colspan="2" name="res">${end}</td>
			</tr>
			<tr>
				<td colspan="2" class="end">${endgame}</td>
			</tr>

		</table>


	</form>

</body>
</html>
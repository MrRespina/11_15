<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hj.css">
</head>
<body>
	<table id="hjTable">
		<tr>
			<td class="tdMain" align="center" colspan="2">홀 or 짝</td>
		</tr>
		<tr>
			<td align="center"><a href="HomeController?userAns=1"><img src="image/hol.png"></a></td>
			<td align="center"><a href="HomeController?userAns=0"><img src="image/jjak.png"></a></td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">동전 : ${c }개</td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">답 : ${r }</td>
		</tr>
		<tr>
			<td class="td1" colspan="2" align="center">${t }전 ${w }승 ${l }패</td>
		</tr>
	</table>
</body>
</html>
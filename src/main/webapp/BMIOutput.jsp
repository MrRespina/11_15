<%@page import="com.chung.nov141.bmi.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMIOutput.jsp</title>
</head>
<body>
	<%--
		request.setCharacterEncoding("UTF-8");
		Guest g = (Guest) request.getAttribute("g");
	--%>
	<table border="1">
		<tr><th colspan="2">BMI 결과</th></tr>
		<tr>
			<td>이름</td>
			<%-- <td><%=g.getName() %></td> --%>
			<td>${g.name }</td>
		</tr>
		<tr>
			<td>키</td>
			<td>${g.height }</td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td>${g.weight }</td>
		</tr>
		<tr>
			<td>bmi</td>
			<td>${g.bmi }</td>
		</tr>
		<tr>
			<td>결과</td>
			<td>${g.result }</td>
		</tr>
		<tr>
			<td colspan="2"><img src="img/${g.image }" style="max-width: 150px;"></td>
		</tr>
	</table>
	
</body>
</html>
package com.chung.nov141.bmi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MVC 패턴을 사용한 JSP Model 2로 BMI 프로그램 만들기

// JSP Model 2 하는 동안 >> 첫 접속(ctrl + f11) 진행하는 곳은 : HomeController

// 0. Servlet에서 실행(ctrl + f11) -> GET방식 접속
// 1. table + form 활용해서 BMI검사(이름/키/몸무게/사진 => 유효성검사 & CSS) : BMIInput.html
// 2. M에서 bmi 계산 -> jsp(BMIOutput.jsp)에서 표현이 가능하게
// 3. POST방식으로 BMI 결과 .jsp페이지에 나오도록

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("BMIInput.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model.calculate(request);
		request.getRequestDispatcher("BMIOutput.jsp").forward(request, response);
	}

}

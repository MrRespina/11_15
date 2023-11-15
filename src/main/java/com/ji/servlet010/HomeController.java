package com.ji.servlet010;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int res;
	static int[] resArr;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!request.getParameterNames().hasMoreElements()) {

			// 임의의 3자릿수 산출을 위한 코드
			// 각 자릿수를 구해 자릿수가 같은 상황을 걸러냄.
			while (true) {
				int r = new Random().nextInt(987) + 12;
				int a = r / 100;
				int b = (r % 100) / 10;
				int c = r % 10;
				if (a != b && b != c && a != c) {
					res = r;
					int[] arr = { a, b, c };
					resArr = arr;
					break;
				}
			}

			// 페이지 처음 시작시 초기화해줌.
			request.setAttribute("a", "?");
			request.setAttribute("b", "?");
			request.setAttribute("c", "?");
			request.setAttribute("count", "0");
			request.setAttribute("ball", "0");
			request.setAttribute("strike", "0");
			request.setAttribute("result", res);
			request.setAttribute("end", "진행중");
		}
		request.getRequestDispatcher("Main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 페이지가 새로 불러지면 jsp페이지에 숨겨진 랜덤 값과 진행 경과를 다시 세팅해줌.
		request.setAttribute("result", res);
		request.setAttribute("end", "진행중");
		
		// Module 작동
		CalcModule.setArray(resArr);
		CalcModule.start(request);
		request.getRequestDispatcher("Main.jsp").forward(request, response);

	}

}

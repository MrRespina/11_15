package com.ji.servlet;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

// 멤버 변수가 필요하면 : singleton
// 멤버 변수가 필요하지 않으면 : static 기반 method

public class HJGameEngine {

	private int t;
	private int win;
	private int lose;
	
	private static final HJGameEngine hge = new HJGameEngine();
	
	private HJGameEngine() {
		
	}
	
	public static HJGameEngine getHge() {
		
		return hge;
		
	}

	public void doHJ(HttpServletRequest request) {

		int userAns = Integer.parseInt(request.getParameter("userAns"));

		int coin = new Random().nextInt(Integer.MAX_VALUE) + 2;

		request.setAttribute("c", coin);

		String gameAns = (coin % 2 == 0) ? "짝" : "홀";
		request.setAttribute("r", gameAns);
		
		if(userAns==(coin%2)) {
			t++;
			win++;
		} else {
			t++;
			lose++;
		}
		
		request.setAttribute("t", t);
		request.setAttribute("w", win);
		request.setAttribute("l", lose);
		
	}

}

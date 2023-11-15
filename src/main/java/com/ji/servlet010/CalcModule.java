package com.ji.servlet010;

import javax.servlet.http.HttpServletRequest;

public class CalcModule {
	
	// 시도 횟수 & 처음에 만들었던 랜덤 3자릿수를 100/10/1로 나누어 0,1,2번 index에 저장한 배열
	private static int count=0;
	private static int[] randArray;
	
	// 시도 횟수 증감용
	public static void plusCount() {
		count++;
	}

	// jsp 페이지에서 넘겨준 숫자값을 받아서 100/10/1의 자릿수로 분할하여 배열로 만듬.
	public static int[] getNum(HttpServletRequest request) {
		
		int num = Integer.parseInt(request.getParameter("number"));
		
		int a = num/100;
		int b = (num%100)/10;
		int c = num%10;
		
		int[] arr = {a,b,c};
		
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("c", c);
			
		return arr;
		
	}
	
	// JSP > HomeController > Module로 배열(처음에 랜덤으로 생성한 숫자의 100/10/1 자릿수 배열)로 가져옴. 
	public static void setArray(int[] arr) {
		
		randArray = arr;
		
	}
	
	// 내가 쓴 숫자 = 랜덤 숫자인지 확인. 자릿수(i,j)까지 같으면 strikeCount++ 숫자는 같지만 자릿수가 다르면 ballCount++
	public static int[] isSame(int[] arr,int[] result) {
		
		int ballCount = 0;
		int strikeCount = 0;
		int[] res = new int[2]; 
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=0;j<result.length;j++) {
				
				if(arr[i]==result[j]) {
					
					if(i==j) {
						strikeCount++;
					}else {
						ballCount++;
					}
					
				}
				
			}
			
		}
		res[0] = strikeCount;
		res[1] = ballCount;
		
		return res;
		
	}
	
	// 스트라이크/볼 갯수 jsp 페이지에 세팅
	public static void setBS(int[] res,HttpServletRequest request) {
		
		request.setAttribute("strike", res[0]);
		request.setAttribute("ball", res[1]);
		
	}
	
	// 스트라이크가 3개면 게임 종료
	public static void endGame(int[] res,HttpServletRequest request) {
		
		plusCount();
		request.setAttribute("count", count);
		
		if(res[0] == 3) {
			request.setAttribute("end", "종료");
			request.setAttribute("endgame", "정답 : "+request.getParameter("number"));
		}
		
	}

	// Module 내 Method를 사용하기 위한 배열들 생성 후 JSP 세팅
	public static void start(HttpServletRequest request) {
		
		int[] myArray = getNum(request);
		int[] result = isSame(myArray,randArray);
		setBS(result,request);
		endGame(result,request);
		
	}

}

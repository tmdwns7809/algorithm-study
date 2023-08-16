package swea_1952;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution_N {
	static int[] price = new int[4]; 
	static int[] months = new int[12]; 
	static ArrayList<Integer> prices = new ArrayList<>(); 
	
	public static void main(String args[]) throws Exception {
		
		//System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int T = Integer.parseInt(br.readLine());
	

		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine()); // 이용권 입력
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken()); 
			}
			
			int daily = price[0];		// 1일 
			int monthly = price[1]; 	// 한달
			int tMonthly = price[2]; 	// 세달
			int annual = price[3]; 		// 1년
			
			st = new StringTokenizer(br.readLine()); 	// 월 이용현황 입력
			int useCnt = 0; 							// 이용월 횟수
			for(int i=0; i<12; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp != 0) useCnt++; 
				months[i] = temp; 
			}
			// 입력 완료
			
			// 1년 이용권
			prices.add(annual); 
			
			// 1일 이용권
			int sum = 0; 
			for(int i=0; i<12; i++) {
				if(months[i] == 0) continue; 
				sum += daily * months[i]; 
			}
			
			prices.add(sum);
			
			// 3달, 1달, 1일
			
			
			
			
			
			// 최소값 출력
			
		}
	}
}
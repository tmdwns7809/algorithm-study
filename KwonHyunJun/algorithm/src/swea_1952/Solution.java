package swea_1952;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 1952 수영장 
public class Solution {
	static int d, m, m3, y; 
	static int[] plan = new int[12]; 
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테케 사이즈

		for (int test_case = 1; test_case <= T; test_case++) {
			st =  new StringTokenizer(br.readLine()); 
			d = Integer.parseInt(st.nextToken()); 
			m = Integer.parseInt(st.nextToken()); 
			m3 = Integer.parseInt(st.nextToken()); 
			y = Integer.parseInt(st.nextToken()); 
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken()); 
			}
			// ---------------------------------Input End---------------------------------
			
			ans = Integer.MAX_VALUE; 
			dfs(0, 0); 
			
//			StringBuilder s = sb.append("#").append(test_case).append(" ").append(ans); 
//			System.out.println(s);
			System.out.printf("#%d %d\n", test_case, ans);
		}
	}
	
	static void dfs(int month, int s) {
		if(month >= 12) {
			ans = Math.min(s, ans); 
			return; 
		}
		
		// 하루 이용권
		dfs(month+1, s + (plan[month] * d)); 
		
		// 한달 이용권
		dfs(month+1, s + m); 
		
		// 세달 이용권 
		dfs(month+3, s + m3); 
		
		// 1년 이용권
		dfs(month+12, s + y); 
		
		
	}

}

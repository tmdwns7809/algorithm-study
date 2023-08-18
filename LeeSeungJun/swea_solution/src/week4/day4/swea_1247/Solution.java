package week4.day4.swea_1247;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int ans;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N+2][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N+2; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			
			dfs(0, 0, 0, 0);
			
			System.out.printf("#%d %d%n", t, ans);
		}
	}
	
	static void dfs(int cnt, int v, int sum, int lastI) {
		if (cnt==N) {
			sum+=Math.abs(arr[lastI][0]-arr[1][0])
			+Math.abs(arr[lastI][1]-arr[1][1]);
			
			if (sum < ans) ans = sum;
			
			return;
		}
		
		for (int i = 2; i < N+2; i++) {
			if ((v&(1<<i))!=0) continue;
			
			dfs(cnt+1, v|(1<<i), 
					sum+Math.abs(arr[lastI][0]-arr[i][0])
					+Math.abs(arr[lastI][1]-arr[i][1]), i);
		}
	}

}

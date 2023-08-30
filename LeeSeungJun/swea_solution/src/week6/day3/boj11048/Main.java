package week6.day3.boj11048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] DP = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (i==0 && j==0) DP[0][0] = map[0][0];
				
				if (j-1 >= 0)
					DP[i][j] = DP[i][j-1] + map[i][j];
				if (j-1>=0 && i-1>=0)
					DP[i][j] = Math.max(DP[i-1][j-1] + map[i][j], DP[i][j]);
				if (i-1 >= 0)
					DP[i][j] = Math.max(DP[i-1][j] + map[i][j], DP[i][j]);
			}
		}
		
		System.out.println(DP[N-1][M-1]);
	}

}

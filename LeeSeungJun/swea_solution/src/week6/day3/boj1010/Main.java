package week6.day3.boj1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
			
			int[][] DP = new int[N][M];
			DP[0][0] = 1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
				}
			}
		}
	}

}

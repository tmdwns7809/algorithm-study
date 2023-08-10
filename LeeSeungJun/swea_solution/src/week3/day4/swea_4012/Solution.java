package week3.day4.swea_4012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int N2;
	static int[][] S;
	static int ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("sample_input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			N2 = N/2;
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			
			com(0,0,0,new int[N2],new int[N2]);
			
			System.out.printf("#%d %d%n",t,ans);
		}
		
	}
	
	static void com(int cnt, int cntA, int cntB, int[] a, int[] b) {
		if (cnt == N) {
			int sumA = 0;
			for (int i = 0; i < N2-1; i++) {
				for (int j = i+1; j < N2; j++) {
					sumA += S[a[i]][a[j]]+S[a[j]][a[i]];
				}
			}
			int sumB = 0;
			for (int i = 0; i < N2-1; i++) {
				for (int j = i+1; j < N2; j++) {
					sumB += S[b[i]][b[j]]+S[b[j]][b[i]];
				}
			}
			
			int diff = Math.abs(sumA-sumB);
			if (diff < ans) ans = diff;
			
			return;
		}
		
		if (cntA<N2) {
			a[cntA]=cnt;
			com(cnt+1, cntA+1, cntB, a, b);
		}
		if (cntB<N2) {
			b[cntB]=cnt;
			com(cnt+1, cntA, cntB+1, a, b);
		}
	}
}

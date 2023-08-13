package week3.day4.swea_5215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int L;
	static int[] Ts;
	static int[] Ks;
	static int ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("sample_input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			Ts = new int[N];
			Ks = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Ts[i] = Integer.parseInt(st.nextToken());
				Ks[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MIN_VALUE;
			
			comb(0,0,0);
			
			System.out.printf("#%d %d%n", t, ans);
		}
	}

	static void comb(int cnt, int sumT, int sumK) {
		if (cnt == N || sumK > L) {
			if (sumK > L) {
				sumT-=Ts[cnt-1];
				sumK-=Ks[cnt-1];
			}
			
			if (sumT > ans) {
				ans = sumT;
			}
			return;
		}
		
		comb(cnt+1, sumT+Ts[cnt], sumK+Ks[cnt]);
		comb(cnt+1, sumT, sumK);
	}
}

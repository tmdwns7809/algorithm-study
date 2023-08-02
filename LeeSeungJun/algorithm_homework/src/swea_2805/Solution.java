package swea_2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int mid = N/2;
			int[][] m = new int[N][N];
			int ans = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					m[i][j] = s.charAt(j) - '0';
					
					if (Math.abs(mid-j) + Math.abs(mid-i) <= mid) {
						ans += m[i][j];
					}
				}
			}
			System.out.printf("#%d %d%n", t, ans);
		}
	}

}

package week3.swea_1952;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ans = Integer.MAX_VALUE;
	static int[] pArr = new int[4];
	static int[] mArr = new int[12];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				pArr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				mArr[i] = Integer.parseInt(st.nextToken());
			}
			
			recur(0, 0, 0);
			
			System.out.printf("#%d %d%n", t, ans);
		}
	}
	
	static void recur(int cnt, int rest, int sum) {
		if (cnt == 12) {
			if (sum < ans) {
				ans = sum;
			}
			return;
		}
		
		if (mArr[cnt]==0 || rest>0) {
			recur(cnt+1, rest>0 ? (rest-1) : rest, sum);
		} else {
			recur(cnt+1, 0, sum+(mArr[cnt]*pArr[0]));
			recur(cnt+1, 0, sum+pArr[1]);
			recur(cnt+1, 2, sum+pArr[2]);
			recur(cnt+1, 11, sum+pArr[3]);
		}
	}

}

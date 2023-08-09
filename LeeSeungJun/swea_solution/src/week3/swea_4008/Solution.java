package week3.swea_4008;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] cs = new int[4];
	static int[] usedcs = new int[4];
	static int[] ns;
	static int N;
	static int ansBig;
	static int ansSmall;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("sample_input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cs[i] = Integer.parseInt(st.nextToken());
			}
			ns = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ns[i] = Integer.parseInt(st.nextToken());
			}
			
			ansBig = Integer.MIN_VALUE;
			ansSmall = Integer.MAX_VALUE;
			usedcs = new int[4];
			
			com(0, ns[0]);
			
			System.out.printf("#%d %d%n", t, ansBig-ansSmall);
		}
	}

	static void com(int cnt, int res) {
		if (cnt == N-1) {
			if (res > ansBig) {
				ansBig = res;
			}
			if (res < ansSmall) {
				ansSmall = res;
			}
			return;
		}
		
		if (usedcs[0] < cs[0]) {
			usedcs[0]++;
			com(cnt+1, res+ns[cnt+1]);
			usedcs[0]--;
		}
		if (usedcs[1] < cs[1]) {
			usedcs[1]++;
			com(cnt+1, res-ns[cnt+1]);
			usedcs[1]--;
		}
		if (usedcs[2] < cs[2]) {
			usedcs[2]++;
			com(cnt+1, res*ns[cnt+1]);
			usedcs[2]--;
		}
		if (usedcs[3] < cs[3]) {
			usedcs[3]++;
			com(cnt+1, res/ns[cnt+1]);
			usedcs[3]--;
		}
	}
}

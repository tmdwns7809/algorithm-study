package week3.day5.boj_19621;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] s = new int[N];
		int[] e = new int[N];
		int[] p = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			e[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] DP = new int[N];
		DP[0] = p[0];
		if (N>1) {
			DP[1] = Math.max(p[1], DP[0]);
			for (int i = 2; i < N; i++) {
				DP[i] = Math.max(DP[i-2]+p[i], DP[i-1]);
			}
		}
		
		System.out.println(DP[N-1]);
	}

}

// start : 2023-08-11 15:30
// end : 2023-08-11 15:55

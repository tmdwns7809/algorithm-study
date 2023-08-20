package week4.day4.boj_16987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] indur;
	static int[] weight;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		indur = new int[N];
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			indur[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MIN_VALUE;
	}

	static void dfs(int cnt, int b) {
		if (cnt == N) {
			if (b > ans) ans = b;
			
			return;
		}

		if (indur[cnt]<=0)
			dfs(cnt+1, b);
		else {
			for (int i = cnt+1; i < N; i++) {
				if (indur[i]<=0) continue;
				
				
			}
		}
	}
}

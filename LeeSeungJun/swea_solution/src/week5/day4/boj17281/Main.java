package week5.day4.boj17281;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[] p = new int[9];
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		p[3] = 0;
		
		dfs(1,1<<3);
		
		System.out.println(ans);
	}
	
	static void dfs(int cnt, int v) {
		if (cnt==9) {
			int now = 0;
			int cb = 0;
			for (int i = 0; i < N; i++) {
//				Queue<Integer> q = new ArrayDeque<>();
//				q.add(0);
//				q.add(0);
//				q.add(0);
				boolean[] b = new boolean[3];
				int out = 0;
				while (true) {
					switch (arr[i][p[cb]]) {
					case 0:
						out++;
						break;

					case 1:
						if (b[0]) now++;
						b[0] = b[1];
						b[1] = b[2];
						b[2] = true;
						break;

					case 2:
						if (b[0]) now++;
						if (b[1]) now++;
						b[0] = b[2];
						b[1] = true;
						b[2] = false;
						break;

					case 3:
						if (b[0]) now++;
						if (b[1]) now++;
						if (b[2]) now++;
						b[0] = true;
						b[1] = false;
						b[2] = false;
						break;

					case 4:
						if (b[0]) now++;
						if (b[1]) now++;
						if (b[2]) now++;
						now++;
						b[0] = false;
						b[1] = false;
						b[2] = false;
						break;
					}
					
					cb=(cb+1)%9;
					
					if (out > 2) break;
				}
			}
			
			if (now > ans) ans = now;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if ((v&1<<i)!=0) continue;
			
			p[i] = cnt;
			dfs(cnt+1, v|1<<i);
		}
	}

}

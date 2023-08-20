package week4.day7.boj17135;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int D;
	
	static int[][] map;
	
	static int[] s = new int[3];
	
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println(ans);
	}

	static void dfs(int cnt, int start) {
		if (cnt == 3) {
			int[][] copy = new int[N][];
			for (int i = 0; i < N; i++) {
				copy[i] = Arrays.copyOf(map[i], M);
			}
			
			int kill = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					archer: for (int j2 = 1; j2 <= D; j2++) {
						for (int c = -(j2-1); c <= (j2-1); c++) {
							int r = j2 - Math.abs(c);
							
							int r2 = N-i-r;
							int c2 = s[j]+c;
							
							if (r2 < 0 || c2 < 0 || c2 >= M) continue;
							
							if (copy[r2][c2] == 1) {
								kill++;
								copy[r2][c2]++;
								break archer;
							} else if (copy[r2][c2] != 0) {
								break archer;
							}
						}
					}
				}
				
				for (int j = N-D; j < N-i; j++) {
					if (j < 0) continue;
					
					for (int j2 = 0; j2 < M; j2++) {
						if (copy[j][j2] > 1) copy[j][j2] = 0; 
					}
				}
			}
			
			if (kill > ans) ans = kill;
			
			return;
		}
		
		for (int i = start; i < M; i++) {
			s[cnt] = i;
			dfs(cnt+1, i+1);
		}
	}
}

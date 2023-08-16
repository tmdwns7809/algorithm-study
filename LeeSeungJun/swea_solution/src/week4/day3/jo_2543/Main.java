package week4.day3.jo_2543;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static boolean ans;
	static int[][] ansMap;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		map = new int[N][N];
		map[r][c] = -1;
		
		dfs(1, map, 0);
		
		ansMap[r][c] = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				sb.append(ansMap[i][j]).append(' ');
			
			sb.append('\n');
		}
			
		
		System.out.println(sb);
	}
	
	static int[][] dr = {{}, {1,1}, {1,1}, {0,1}, {0,1}};
	static int[][] dc = {{}, {0,-1}, {0,1}, {1,1}, {1,0}};
	
	static void dfs(int cnt, int[][] m, int sr) {
		boolean clear = true;
		for (int i = sr; i < N; i++) 
			for (int j = 0; j < N; j++) {
				if (m[i][j] != 0) continue;
				
				for (int t = 4; t >= 1; t--) {
					clear = false;
					
					m[i][j] = t;
					int ni0 = i+dr[t][0];
					int nj0 = j+dc[t][0];
					int ni1 = i+dr[t][1];
					int nj1 = j+dc[t][1];
					
					if (ni0>=0 && ni0<N && nj0>=0 && nj0<N && m[ni0][nj0]==0 &&
							ni1>=0 && ni1<N && nj1>=0 && nj1<N && m[ni1][nj1]==0) {
						m[ni0][nj0] = t;
						m[ni1][nj1] = t;
						dfs(cnt+3,m,i);
						m[ni0][nj0] = 0;
						m[ni1][nj1] = 0;
					}
					m[i][j] = 0;
					
					if (ans)
						return;
				}
				
				if (m[i][j] == 0) return;
			}
		
		if (clear) {
			if (!ans) {
				ansMap = new int[N][];
				
				for (int i = 0; i < N; i++) 
					ansMap[i] = Arrays.copyOf(m[i], N);
			}
			
			ans = true;
			
			return;
		} else
			return;
	}
}

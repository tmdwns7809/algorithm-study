package week4.day3.jo_2543;

import java.util.Scanner;

public class Main_Retry2 {
	
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		map = new int[N][N];
		
		dfs(N, 0, 0, 0, X, Y);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	static void dfs(int size, int r, int c, int n, int nr, int nc) {
		if (size==1) {
			map[r][c] = n;
			return;
		}
		
		int half = size/2;
		int n2 = ((nr-r)/half)*2 + (nc-c)/half + 1;
		
		switch (n2) {
		case 1:
			dfs(half, r, c, n, nr, nc);
			dfs(half, r, c+half, n2, r+half-1, c+half);
			dfs(half, r+half, c, n2, r+half, c+half-1);
			dfs(half, r+half, c+half, n2, r+half, c+half);
			break;
			
		case 2:
			dfs(half, r, c, n2, r+half-1, c+half-1);
			dfs(half, r, c+half, n, nr, nc);
			dfs(half, r+half, c, n2, r+half, c+half-1);
			dfs(half, r+half, c+half, n2, r+half, c+half);
			break;
			
		case 3:
			dfs(half, r, c, n2, r+half-1, c+half-1);
			dfs(half, r, c+half, n2, r+half-1, c+half);
			dfs(half, r+half, c, n, nr, nc);
			dfs(half, r+half, c+half, n2, r+half, c+half);
			break;
			
		case 4:
			dfs(half, r, c, n2, r+half-1, c+half-1);
			dfs(half, r, c+half, n2, r+half-1, c+half);
			dfs(half, r+half, c, n2, r+half, c+half-1);
			dfs(half, r+half, c+half, n, nr, nc);
			break;
		}
	
		
	}
}

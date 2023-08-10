package week3.day3.boj_16935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int big = N > M ? N : M;
		int diff = Math.abs(N-M);
		int[][] map = new int[big][big];
		int[][] ans = new int[big][big];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int r = 0; r < R; r++) {
			int c = Integer.parseInt(st.nextToken());
			switch (c) {
			case 1:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						ans[i][j] = map[N-1-i][j];
					}
				}
				break;

			case 2:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						ans[i][j] = map[i][M-1-j];
					}
				}
				break;

			case 3:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						ans[j][N-1-i] = map[i][j];
					}
				}
				int temp = N;
				N = M;
				M = temp;
				break;

			case 4:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						ans[M-1-j][i] = map[i][j];
					}
				}
				int temp2 = N;
				N = M;
				M = temp2;
				break;

			case 5:
			case 6:
				int[] drm = {0,0,1,1};
				int[] dcm = {0,1,1,0};
				int[] dr = {0,1,0,-1};
				int[] dc = {1,0,-1,0};
				int N2 = N/2;
				int M2 = M/2;
				if (c == 6) {
					drm = new int[]{0,1,1,0};
					dcm = new int[]{0,0,1,1};
					dr = new int[]{1,0,-1,0};
					dc = new int[]{0,1,0,-1};
				}
				
				for (int d = 0; d < 4; d++) {
					for (int i = 0; i < N2; i++) {
						for (int j = 0; j < M2; j++) {
							ans[i+drm[d]*N2+dr[d]*N2][j+dcm[d]*M2+dc[d]*M2] = map[i+drm[d]*N2][j+dcm[d]*M2];
						}
					}
				}
				break;
			}

			map = ans;
			ans = new int[big][big];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}

}

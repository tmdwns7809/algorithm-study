package week3.day4.swea_1861;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] dis = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			int ans = 0;
			int ansdis = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dis[i][j]!=0) {
						continue;
					}
					
					Queue<int[]> q = new ArrayDeque<int[]>();
					q.add(new int[]{i,j,1});
					while (!q.isEmpty()) {
						int[] p = q.poll();
						dis[p[0]][p[1]] = p[2];
						
						if (p[2]>ansdis || (p[2]==ansdis && map[i][j]<ans)) {
							ansdis = p[2];
							ans = map[i][j];
						}
						
						for (int d = 0; d < 4; d++) {
							int nr = p[0]+dr[d];
							int nc = p[1]+dc[d];
							
							if (nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==(map[p[0]][p[1]]+1)
									&& (p[2]+1)>=dis[nr][nc]) {
								q.add(new int[] {nr,nc,p[2]+1});
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d %d%n", t, ans, ansdis);
		}
	}

}

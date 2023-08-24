package week5.day4.swea1873;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			
			int[] p = new int[3];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^') {
						p[0]=i;
						p[1]=j;
						p[2]=0;
					}
					else if (map[i][j] == 'v') {
						p[0]=i;
						p[1]=j;
						p[2]=1;
					}
					else if (map[i][j] == '<') {
						p[0]=i;
						p[1]=j;
						p[2]=2;
					}
					else if (map[i][j] == '>') {
						p[0]=i;
						p[1]=j;
						p[2]=3;
					}
				}
			}
			
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			
			int C = Integer.parseInt(br.readLine());
			char[] carr = br.readLine().toCharArray();
			for (int i = 0; i < C; i++) {
				switch (carr[i]) {
				case 'S':
					int sIndex = 1;
					while (true) {
						int nr = p[0] + dr[p[2]]*sIndex;
						int nc = p[1] + dc[p[2]]*sIndex;
						
						if (nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc]=='#') break;
						
						if (map[nr][nc]=='*') {
							map[nr][nc] = '.';
							break;
						}
						
						sIndex++;
					}
					break;

				default:
					p[2] = (carr[i]=='U' ? 0 : (carr[i]=='D' ? 1
									: (carr[i]=='L' ? 2 : 3)));
					map[p[0]][p[1]] = (p[2]==0 ? '^' : (p[2]==1 ? 'v'
							: (p[2]==2 ? '<' : '>')));
					
					int nr = p[0] + dr[p[2]];
					int nc = p[1] + dc[p[2]];
					
					if (nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]=='.') {
						map[nr][nc] = map[p[0]][p[1]];
						map[p[0]][p[1]] = '.';
						p[0] = nr;
						p[1] = nc;
					}
					
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(' ');
			for (int i = 0; i < H; i++) {
				sb.append(map[i]).append('\n');
			}
			
			System.out.print(sb);
		}
	}

}

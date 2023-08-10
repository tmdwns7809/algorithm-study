package week3.day4.swea_1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			int[] p = new int[3];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j]=='<'||map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='>') {
						p[0] = i;
						p[1] = j;
						p[2] = map[i][j]=='^' ? 0 : 
							(map[i][j]=='v' ? 1 :
								(map[i][j]=='<' ? 2 : 3)); 
					}
				}
			}
			
			
			int N = Integer.parseInt(br.readLine());
			char[] inputs = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				if (inputs[i]=='S') {
					int nr = p[0]+dr[p[2]];
					int nc = p[1]+dc[p[2]];
					while (nr>=0 && nr<H && nc>=0 && nc<W
							&& (map[nr][nc]=='.' || map[nr][nc]=='-')) {
						nr += dr[p[2]];
						nc += dc[p[2]];
					}
					if (nr>=0 && nr<H && nc>=0 && nc<W
							&& map[nr][nc]=='*') {
						map[nr][nc] = '.';
					}
				} else {
					int d = inputs[i]=='U' ? 0 : 
						(inputs[i]=='D' ? 1 :
							(inputs[i]=='L' ? 2 : 3));
					
					map[p[0]][p[1]] = d==0 ? '^' : 
						(d==1 ? 'v' : (d==2 ? '<' : '>'));
					p[2] = d;
					
					int nr = p[0]+dr[d];
					int nc = p[1]+dc[d];
					if (nr>=0 && nr<H && nc>=0 && nc<W
							&& map[nr][nc]=='.') {
						map[nr][nc] = map[p[0]][p[1]];
						map[p[0]][p[1]] = '.';
						p[0] = nr;
						p[1] = nc;
					}
				}
			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(' ');
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			sb.delete(sb.length()-1, sb.length());
			System.out.println(sb);
		}
	}

}

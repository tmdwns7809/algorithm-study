package week3.boj_16926;

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
		int[][] map = new int[N][M];
		int[][] ans = new int[N][M];
		boolean[][] mapV = new boolean[N][M];
		boolean[][] ansV = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		int size = Math.min(N, M)/2;
		for (int i = 0; i < size; i++) {
			int round = (N-i*2-1)*2 + (M-i*2-1)*2;
			int RR = R%round;
			int r=i, c=i, d=0;
			int ar=i, ac=i, ad=0;
			int cnt=0;
			while (true) {
				if (cnt == RR) {
					break;
				}
				
				int nar = ar+dr[ad];
				int nac = ac+dc[ad];
				if (i==0) {
					if (nar<0||nar>=N||nac<0||nac>=M) {
						ad = (ad+1)%4;
						nar = ar+dr[ad];
						nac = ac+dc[ad];
					}
				} else {
					if (ans[nar][nac]!=0) {
						ad = (ad+1)%4;
						nar = ar+dr[ad];
						nac = ac+dc[ad];
					}
				}
				
				ar = nar;
				ac = nac;
				
				cnt++;
			}
			cnt=0;
			while (true) {
				if (cnt == round) {
					break;
				}
				
				ans[ar][ac] = map[r][c];
				ansV[ar][ac] = true;
				mapV[r][c] = true;

				int nr = r+dr[d];
				int nc = c+dc[d];
				int nar = ar+dr[ad];
				int nac = ac+dc[ad];

				if (i==0) {
					if (nar<0||nar>=N||nac<0||nac>=M) {
						ad = (ad+1)%4;
						nar = ar+dr[ad];
						nac = ac+dc[ad];
					}
					if (nr<0||nr>=N||nc<0||nc>=M) {
						d = (d+1)%4;
						nr = r+dr[d];
						nc = c+dc[d];
					}
				} else {
					if (ansV[nar][nac]) {
						ad = (ad+1)%4;
						nar = ar+dr[ad];
						nac = ac+dc[ad];
					}
					if (mapV[nr][nc]) {
						d = (d+1)%4;
						nr = r+dr[d];
						nc = c+dc[d];
					}
				}

				r = nr;
				c = nc;
				ar = nar;
				ac = nac;
				
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < M; j2++) {
				sb.append(ans[j][j2]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}

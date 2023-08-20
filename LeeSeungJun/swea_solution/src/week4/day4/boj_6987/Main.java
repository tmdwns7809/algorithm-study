package week4.day4.boj_6987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[6][3];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean fail = false;
			for (int j = 0; j < 6; j++) {
				int sum = 0;
				
				for (int j2 = 0; j2 < 3; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());
					sum += map[j][j2];
				}
				
				if (sum != 5) fail = true;
			}
			
			ans = 0;
			
			if (!fail) dfs(1, 0);
			
			
			System.out.printf("%d ", ans);
		}
		

	}
	
	static void dfs(int cnt, int start) {
		if (cnt == 6) {
			if (map[5][0]==0 && map[5][1]==0 && map[5][2]==0) ans = 1;
			
			return;
		}
		
		for (int i = start+1; i < 6; i++) {
			for (int j = 0; j <= map[i][0]; j++) {
				for (int j2 = 0; j2 <= map[i][1]; j2++) {
					for (int k = 0; k <= map[i][2]; k++) {
						if (j<=map[start][2] && j2<=map[start][1] && k<=map[start][0]) {
							map[start][2] -= j;
							map[start][1] -= j2;
							map[start][0] -= k;
							map[i][0] -= j;
							map[i][1] -= j2;
							map[i][2] -= k;
							dfs(cnt+1, i);
							map[start][2] += j;
							map[start][1] += j2;
							map[start][0] += k;
							map[i][0] += j;
							map[i][1] += j2;
							map[i][2] += k;
						}
					}
				}
			}
		}
	}

}

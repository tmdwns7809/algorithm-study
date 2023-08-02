package swea_1210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			
			int[][] map = new int[100][100];
			int x = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						x = j;
					}
				}
			}
			
			
			for (int i = 99; i >= 0; i--) {
				if (x-1 >= 0 && map[i][x-1] == 1) {
					while (x-1 >= 0 && map[i][x-1] == 1) {
						x--;
					}
				} else if (x+1 < 100 && map[i][x+1] == 1) {
					while (x+1 < 100 && map[i][x+1] == 1) {
						x++;
					}
				}
			}
			
			System.out.printf("#%d %d%n", t, x);
		}
	}

}

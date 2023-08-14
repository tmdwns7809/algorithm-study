package week4.day1.boj_2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		devide(N, 0, 0);
		
		System.out.println(white);
		System.out.println(blue);
	}

	static void devide(int size, int startR, int startC) {
		int a = map[startR][startC];
		boolean full = true;
		mainloop: for (int i = startR; i < size; i++) {
			for (int j = startC+1; j < size; j++) {
				if (map[i][j]!=a) {
					full = false;
					break mainloop;
				}
			}
		}
		
		if (full) {
			if (a==0) {
				white++;
			} else {
				blue++;
			}
		} else {
			int nsize = size/2;
			devide(nsize, startR, startC);
			devide(nsize, startR, startC+nsize);
			devide(nsize, startR+nsize, startC);
			devide(nsize, startR+nsize, startC+nsize);
		}
	}
}

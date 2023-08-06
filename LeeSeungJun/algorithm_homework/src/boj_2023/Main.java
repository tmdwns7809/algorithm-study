package boj_2023;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] n1s = {2,3,5,7};
		for (int i =0; i < 4; i++) {
			Solve(1, n1s[i]);
		}
		System.out.println(sb);
	}
	
	static void Solve(int cnt, int num) {
		if (cnt == N) {
			sb.append(num).append('\n');
			return;
		}

		for (int i = 1; i < 10; i+=2) {
			int j = 3;
			int newNum = num*10 + i;
			while (true) {
				if (newNum%j == 0) {
					break;
				}
				
				if (j > newNum/j) {
					Solve(cnt+1, newNum);
					break;
				}
				
				j+=2;
			}
		}
	}
}
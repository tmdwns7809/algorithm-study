package solution_SWEA_12052;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{

			/////////////////////////////////////////////////////////////////////////////////////////////
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] ts = new char[N][M];
			
			for (int i = 0; i < N; i++) {
				ts[i] = sc.next().toCharArray();
			}
			
			String ans = "YES";

			int ms = 0;
			mainloop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ts[i][j] == '#') {
						ms++;
					}
					if (j == M - 1 || ts[i][j] == '.') {
						if (ms % 2 != 0) {
							ans = "NO";
							break mainloop;
						}
						ms = 0;
					}
				}
			}
			
			int ns = 0;
			mainloop: for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (ts[j][i] == '#') {
						ns++;
					}
					if (j == N - 1 || ts[j][i] == '.') {
						if (ns % 2 != 0) {
							ans = "NO";
							break mainloop;
						}
						ns = 0;
					}
				}
			}
			
			System.out.printf("#%d %s%n", test_case, ans);
			
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}

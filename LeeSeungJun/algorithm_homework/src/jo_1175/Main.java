package jo_1175;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[] v = new boolean[7];
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		recursion(0, 0, new StringBuilder());
	}

	static void recursion(int cnt, int sum, StringBuilder sb) {
		if (cnt == N) {
			if (sum == M) {
				System.out.println(sb);
			}
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			sb.append(i).append(' ');
			recursion(cnt+1, sum+i, sb);
			sb.delete(sb.length()-2, sb.length());
		}
	}
}

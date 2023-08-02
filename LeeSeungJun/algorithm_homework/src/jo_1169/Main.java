package jo_1169;

import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] v = new boolean[7];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		switch (M) {
		case 1:
			recursion(0, new StringBuilder());
			break;
			
		case 2:
			combination(0, 1, new StringBuilder());
			break;
			
		case 3:
			permutation(0, new StringBuilder());
			break;
		}

	}

	static void recursion(int cnt, StringBuilder sb) {
		if (cnt == N) {
			System.out.println(sb);
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			sb.append(i).append(' ');
			recursion(cnt+1, sb);
			sb.delete(sb.length()-2, sb.length());
		}
	}

	static void combination(int cnt, int start, StringBuilder sb) {
		if (cnt == N) {
			System.out.println(sb);
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			sb.append(i).append(' ');
			combination(cnt+1, i, sb);
			sb.delete(sb.length()-2, sb.length());
		}
	}

	static void permutation(int cnt, StringBuilder sb) {
		if (cnt == N) {
			System.out.println(sb);
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			if (v[i]) {
				continue;
			}
			
			sb.append(i).append(' ');
			v[i] = true;
			permutation(cnt+1, sb);
			v[i] = false;
			sb.delete(sb.length()-2, sb.length());
		}
	}
}

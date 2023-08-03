package boj_2961;

import java.util.Scanner;

public class Main {
	static int N;
	
	static int[] sin;
	static int[] ssn;
	static boolean[] c;
	
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		sin = new int[N];
		ssn = new int[N];
		c = new boolean[N];
		for (int i = 0; i < N; i++) {
			sin[i] = sc.nextInt();
			ssn[i] = sc.nextInt();
		}
		
		Set(0, 0, 1, 0);
		
		System.out.println(ans);
	}
	
	public static void Set(int cnt, int n, int sinS, int ssnS) {
		if (cnt == N) {
			if (n > 0 && Math.abs(sinS - ssnS) < ans) {
				ans = Math.abs(sinS - ssnS);
			}
			return;
		}
		
		c[cnt] = true;
		Set(cnt+1, n+1, sinS*sin[cnt], ssnS+ssn[cnt]);
		c[cnt] = false;
		Set(cnt+1, n, sinS, ssnS);
		
	}

}

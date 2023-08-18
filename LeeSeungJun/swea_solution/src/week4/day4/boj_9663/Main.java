package week4.day4.boj_9663;

import java.util.Scanner;

public class Main {
	static int ans;
	static int N;
	static int[] queen = new int[14];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dfs(0);
		
		System.out.println(ans);
	}

	static void dfs(int n) {
		if (n==N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			boolean okay = true;
			for (int j = 0; j < n; j++) {
				int left = queen[j]-(n-j);
				int right = queen[j]+(n-j);
				if (i==queen[j] || (left>=0 && left==i)
						|| (right<N && right==i)) {
					okay = false;
					break;
				}
			}
			
			if (okay) {
				queen[n] = i;
				dfs(n+1);
			}
		}
	}
}

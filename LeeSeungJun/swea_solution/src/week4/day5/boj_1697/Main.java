package week4.day5.boj_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {N,0});
		
		boolean[] v = new boolean[100_001];
		v[N] = true;
		
		int ans = 0;
		while (!q.isEmpty()) {
			int[] p = q.poll();
			
			if (p[0] == K) {
				ans = p[1];
				break;
			}
			
			int s = p[1]+1;
			int m = p[0]-1;
			if (m >= 0 && !v[m]) {
				v[m] = true;
				q.add(new int[] {m,s});
			}
			int pl = p[0]+1;
			if (pl <= K && !v[pl]) {
				v[pl] = true;
				q.add(new int[] {pl,s});
			}
			int mul = p[0]*2;
			if (p[0] < K && mul<=100_000 && !v[mul]) {
				v[mul] = true;
				q.add(new int[] {mul,s});
			}
		}
		
		System.out.println(ans);
	}

}

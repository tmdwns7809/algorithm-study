package week3.boj_1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		int c = 1;
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while (!q.isEmpty()) {
			int p = q.poll();
			if (c%K == 0) {
				sb.append(p).append(", ");
			} else {
				q.add(p);
			}
			c++;
		}
		sb.delete(sb.length() - 2, sb.length()).append('>');
		
		System.out.println(sb);
	}

}

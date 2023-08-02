package boj_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static boolean[] v;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		v = new boolean[N+1];
		sb = new StringBuilder();
		
		recur(0);
		
	}
	
	static void recur(int m) {
		if (m == M) {
			System.out.println(sb.toString());
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (v[i])
				continue;
			
			sb.append(i).append(" ");
			v[i] = true;
			recur(m+1);
			v[i] = false;
			sb.delete(m*2, m*2 + 2);
		}
	}

}

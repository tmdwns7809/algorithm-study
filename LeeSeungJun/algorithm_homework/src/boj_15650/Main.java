package boj_15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Com(0,1,new StringBuilder());
	}

	static void Com(int cnt, int start, StringBuilder sb) {
		if (cnt == M) {
			System.out.println(sb.toString());
			return;
		}
		
		for (int i = start; i <= N; i++) {
			sb.append(i).append(' ');
			Com(cnt+1, i+1, sb);
			sb.delete(sb.length() - 2, sb.length());
		}
	}
}

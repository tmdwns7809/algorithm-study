package week3.boj_1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> hSet = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hSet.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(hSet.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append('\n');
		}
		System.out.println(sb);
		
	}

}

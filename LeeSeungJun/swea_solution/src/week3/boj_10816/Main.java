package week3.boj_10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (!hmap.containsKey(n)) {
				hmap.put(n, 0);
			}
			
			hmap.put(n, hmap.get(n)+1);
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			sb.append(hmap.containsKey(n) ? hmap.get(n) : 0).append(' ');
		}
		System.out.println(sb);
	}

}

package boj_11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] sarr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sarr[i] = arr[i] + (i>0 ? sarr[i-1] : 0); 
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int last = Integer.parseInt(st.nextToken()) - 2;
			int to = Integer.parseInt(st.nextToken()) - 1;

			sb.append(sarr[to] - (last>=0 ? sarr[last] : 0)).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}

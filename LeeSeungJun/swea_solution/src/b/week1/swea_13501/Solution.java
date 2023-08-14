package b.week1.swea_13501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			LinkedList<Integer> list = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				switch (st.nextToken()) {
				case "I":
					list.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
					
				case "D":
					list.remove(Integer.parseInt(st.nextToken()));
					break;
					
				case "C":
					list.set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				}
			}
			
			System.out.printf("#%d %d%n", t, L < list.size() ? list.get(L) : -1);
		}
	}

}

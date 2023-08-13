package b.week1.swea_1230;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<String> list = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int x, y;
				List<String> list2;
				switch (st.nextToken()) {
				case "I":
					list2 = new LinkedList<>();
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list2.add(st.nextToken());
					}
					list.addAll(x, list2);
					break;
					
				case "D":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
					break;
					
				case "A":
					list2 = new LinkedList<>();
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list2.add(st.nextToken());
					}
					list.addAll(list2);
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(' ');
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(' ');
			}
			sb.append('\n');
			
			System.out.println(sb);
		}
	}

}

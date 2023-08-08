package week3.swea_1228;

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
			List<Integer> arr = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				if (i > 9) {
					break;
				}
				
				arr.add(Integer.parseInt(st.nextToken()));
			}
			int I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < I; i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());;
				for (int j = idx; j < n + idx; j++) {
					if (j < arr.size()) {
						arr.add(j, Integer.parseInt(st.nextToken()));
					} else {
						arr.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(' ');
			for (int j = 0; j < 10; j++) {
				sb.append(arr.get(j)).append(' ');
			}
			System.out.println(sb);
		}
	}

}

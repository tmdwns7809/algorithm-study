package swea_1225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			
			sb.append('#').append(t).append(' ');
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				int n = Integer.parseInt(st.nextToken());
				q.add(n);
			}
			
			int i = 0;
			while (true) {
				int n = q.poll() - (i%5 + 1);
				if (n <= 0) {
					n = 0;
					q.add(n);
					break;
				}
				q.add(n);
				
				i++;
			}

			for (int j = 0; j < 8; j++) {
				sb.append(q.poll()).append(' ');
			}

			sb.append('\n');
			
		}
		
		System.out.println(sb);
	}

}

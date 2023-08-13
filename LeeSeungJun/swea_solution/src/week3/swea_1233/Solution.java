package week3.swea_1233;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (ans == 0) {
					continue;
				}
				st.nextToken();
				String s = st.nextToken();
				if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
					if (st.countTokens()!=2) {
						ans=0;
					}
				} else if (st.countTokens()!=0) {
					ans=0;
				}
			}
			System.out.printf("#%d %d%n", t, ans);
		}
	}

}

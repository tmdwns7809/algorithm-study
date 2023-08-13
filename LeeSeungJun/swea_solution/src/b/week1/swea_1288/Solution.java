package b.week1.swea_1288;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("sample_input.txt").getFile()));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int ans = 1;
			int checked = 0;
			int full = 0b11111_11111;
			while (true) {
				int n = ans*N;
				
				while (n!=0) {
					checked |= 1<<(n%10);
					n /= 10;
				}
				
				if (checked==full)
					break;
				
				ans++;
			}
			
			System.out.printf("#%d %d%n", t, ans*N);
		}
		
	}

}

package week4.day3.boj_1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		while (r!=0 || c!=0) {
			int half = (int)Math.pow(2, N-1);
			int pos = 2*(r/half) + (c/half);
			ans += half*half*pos;
			r %= half;
			c %= half;
			N--;
		}
		
		System.out.println(ans);
	}

}

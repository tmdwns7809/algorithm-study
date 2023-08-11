package week3.day5.boj_16435;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] h = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(h);
		
		for (int i = 0; i < N; i++) {
			if (h[i]<=L) {
				L++;
			} else {
				break;
			}
		}
		
		System.out.println(L);
	}

}

// start: 2023-08-11 17:46
// end: 2023-08-11 17:53
package week5.day5.swea14510;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("Sample_input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int i1 = N-2;
			int i2 = N-2;
			
			int day = 0;
			
			while (arr[0] < arr[N-1]) {
				int add = day%2==0 ? 1 : 2;
				
			}
			
			
			System.out.printf("#%d %d%n", t, day);
		}
		
	}

}

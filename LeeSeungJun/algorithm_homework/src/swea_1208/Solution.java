package swea_1208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(Solution.class.getResource("./input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);

			int bigStart = 100;
			int smallStart = -1;
			while (true) {
				if (bigStart == 100) {
					bigStart = 98;
					while (true) {
						if (arr[99] == arr[bigStart]) {
							bigStart--;
						} else {
							bigStart++;
							break;
						}
					}
				}
				if (smallStart == -1) {
					smallStart = 1;
					while (true) {
						if (arr[0] == arr[smallStart]) {
							smallStart++;
						} else {
							smallStart--;
							break;
						}
					}
				}
				
				arr[bigStart]--;
				bigStart++;
				arr[smallStart]++;
				smallStart--;
				
				dump--;
				
				if (dump == 0 || arr[99] - arr[0] <= 1) {
					break;
				}
			}
			
			System.out.printf("#%d %d%n", t, arr[99] - arr[0]);

		}

	}

}

package week4.day1.boj_10815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(st.nextToken());
			int upperBound = N-1;
			int lowerBound = 0;
			int mid = (upperBound+lowerBound)/2;
			while (upperBound > lowerBound) {
				if (m > arr[mid]) {
					lowerBound = mid+1;
				} else {
					upperBound = mid;
				}
				mid = (upperBound+lowerBound)/2;
			}
			
			sb.append(arr[mid]==m ? 1 : 0).append(' ');
		}
		
		System.out.println(sb);
	}

}

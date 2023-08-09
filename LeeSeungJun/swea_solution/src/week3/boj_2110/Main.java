package week3.boj_2110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		// 입력 및 초기화 종료
		
		// 이분 탐색을 위해 오름차순으로 정렬
		Arrays.sort(arr);
		
		// 이분 탐색
		int lowerBound = 1;
		int upperBound = arr[N-1] - arr[0] + 1;
		while (upperBound > lowerBound) {
			int mid = (lowerBound+upperBound)/2;
			
			int maxC = 1;
			int lastIdx = 0;
			for (int i = 1; i < N; i++) {
				int distance = arr[i]-arr[lastIdx];
				if (distance >= mid) {
					maxC++;
					lastIdx = i;
				}
			}
			
			if (maxC < C) {
				upperBound = mid;
			} else {
				
				if (maxC > C) {
					lowerBound = mid;
				} else {
					lowerBound = mid+1;
				}
				
//				lowerBound = mid+1;
				
			}
			
			
		}
		
		System.out.println(lowerBound-1);
	}

}

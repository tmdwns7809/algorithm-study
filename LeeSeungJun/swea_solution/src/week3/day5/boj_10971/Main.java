package week3.day5.boj_10971;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] W = new int[N][N];
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		do {
			int p = W[arr[N-1]][arr[0]];
			if (p!=0) {
				for (int i = 1; i < N; i++) {
					p += W[arr[i-1]][arr[i]];
					if (W[arr[i-1]][arr[i]]==0) {
						p = Integer.MAX_VALUE;
						break;
					}
				}
				if (p < ans) ans = p;
			}
		} while (np(arr));
		
		System.out.println(ans);
	}

	static boolean np(int[] arr) {
		int i = arr.length-1;
		int j = i;
		int k = i;
		
		while (i>0 && arr[i-1]>=arr[i]) {
			i--;
		}
		
		if (i==0) return false;
		
		while (arr[i-1]>=arr[j]) {
			j--;
		}

		swap(arr, i-1, j);
		
		while (k>i) {
			swap(arr, i, k);
			i++;
			k--;
		}
		
		return true;
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

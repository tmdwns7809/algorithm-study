package boj_3040;

import java.util.Scanner;

public class Main {
	static int[] arr = new int[9];
	static int[] arr7 = new int[7];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		Com(0, 0, 0);

	}
	
	static boolean Com(int cnt, int sum, int start) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int i : arr7) {
					System.out.println(i);
				}
				return true;
			}
			return false;
		}
		
		for (int i = start; i < 9; i++) {
			arr7[cnt] = arr[i];
			if (Com(cnt+1, sum+arr[i], i+1)) {
				return true;
			}
		}
		return false;
	}

}

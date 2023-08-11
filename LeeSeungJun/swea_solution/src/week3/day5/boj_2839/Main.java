package week3.day5.boj_2839;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int ans = -1;
		for (int i = N/5; i >= 0; i--) {
			int r = N - i*5;
			if (r%3 == 0) {
				ans = i + r/3;
				break;
			}
		}
		
		System.out.println(ans);
	}

}

// start: 2023-08-11 17:38
// end: 2023-08-11 17:45

package boj_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bunhae {
	static int N; 
	static int cnt = 0; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(sc.readLine()); 
		
		// �옄由ъ닔 援ы븯湲�
		int num = N; 
		while(num > 0) {
			cnt++;
			num /= 10; 
		}
		
		int ans = 0; 
		
		
		for(int i=0; i<N; i++) {
			int sum = 0;
			int temp =i; 
			
			for(int j=0; j<cnt; j++) {
				sum += temp%10; 
				temp /= 10; 
			}
			
			sum += i;
			if(sum == N) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		
	}

}
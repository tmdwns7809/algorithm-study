package boj_1436;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		
		int i = 666; 
		int cnt = 0; 
		
		while(true) {
			String str = i + "" ;
			if(str.contains("666")) {
				cnt++; 
			}
			
			if(cnt == N) {
				System.out.println(i);
				break;
			}
			
			i++; 
		}
		
		sc.close();
	}
}

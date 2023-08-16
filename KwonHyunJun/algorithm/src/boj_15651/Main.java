package boj_15651;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int N, R; 
	static int[] nums;
	static 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		
		N = sc.nextInt();
		R = sc.nextInt(); 
		nums = new int[R]; 
		
		perm(0); 
		bw.flush();
	}
	
	static void perm(int cnt) throws IOException {
		if(cnt == R) {
			for(int a : nums) {
				bw.write(a+" "); 
			}
			bw.write("\n");
			return; 
		}
		
		for(int i=0; i<N; i++) {
			nums[cnt] = i+1; 
			perm(cnt+1); 
		}
	}
	
}

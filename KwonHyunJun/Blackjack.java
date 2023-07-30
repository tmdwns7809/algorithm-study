package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
	static int N, M;
	static int[] arr; 
	static ArrayList<Integer> sumArr = new ArrayList<>(); 

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N]; 
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt(); 
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;  
				for(int k =0; k < N; k++) {
					if(k==i || k==j) continue;
//					System.out.println(i+" "+j+" "+k); 
					solve(i, j, k); 
				}
			}
		}
		
		int max = Integer.MIN_VALUE; 
		
		for(int i = 0; i<sumArr.size(); i++) {
			if(sumArr.get(i)>max) max = sumArr.get(i); 
		}
		
		System.out.println(max);
		
	}

	private static void solve(int i, int j, int k) {
		// TODO Auto-generated method stub
		int sum = 0; 
		
		sum += arr[i]; 
		sum += arr[j]; 
		sum += arr[k]; 
		
		if(sum <= M) {
			sumArr.add(sum);
		}
		
	}
	
	

}

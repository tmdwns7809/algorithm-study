package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math { 
	
	static int A, B, C, D, E, F; 
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		A = Integer.parseInt(st.nextToken()); 
		B = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		D = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken()); 
		F = Integer.parseInt(st.nextToken()); 
		
		for(int i=-999; i<1000; i++) {
			for(int j=-999; j<1000;j++) {
				if(((A*i)+(B*j) == C)&&((D*i)+(E*j) == F)){
					System.out.println(i + " " + j);
					break; 
				}
			}
		}	
	}
}

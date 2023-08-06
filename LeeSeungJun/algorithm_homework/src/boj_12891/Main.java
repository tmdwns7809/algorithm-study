package boj_12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] arr = new char[S];
		for (int i = 0; i < S; i++) {
			arr[i] = (char)br.read();
		}
		br.readLine();
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); 
		int C = Integer.parseInt(st.nextToken()); 
		int G = Integer.parseInt(st.nextToken()); 
		int T = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		int a=0, c=0, g=0, t=0;
		for (int i = 0; i < P; i++) {
			switch (arr[i]) {
			case 'A':
				a++;
				break;
				
			case 'C':
				c++;
				break;
				
			case 'G':
				g++;
				break;
				
			case 'T':
				t++;
				break;

			default:
				break;
			}
		}
		if (a>=A && c>=C && g>=G && t>=T) {
			ans++;
		}

		for (int i = P; i < S; i++) {
			switch (arr[i]) {
			case 'A':
				a++;
				break;
				
			case 'C':
				c++;
				break;
				
			case 'G':
				g++;
				break;
				
			case 'T':
				t++;
				break;

			default:
				break;
			}
			
			switch (arr[i-P]) {
			case 'A':
				a--;
				break;
				
			case 'C':
				c--;
				break;
				
			case 'G':
				g--;
				break;
				
			case 'T':
				t--;
				break;

			default:
				break;
			}
			if (a>=A && c>=C && g>=G && t>=T) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}

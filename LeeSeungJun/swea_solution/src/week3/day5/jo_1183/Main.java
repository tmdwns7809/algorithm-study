package week3.day5.jo_1183;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int W;
	static int[] arr;
	static int[] ans;
	static boolean found;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		W = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		recur(5, 0, new int[6]);
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < 6; i++) {
			count += ans[i];
			sb.append(ans[i]).append(' ');
		}
		sb.insert(0, '\n').insert(0, count);
		
		System.out.println(sb);
	}
	
	static void recur(int cnt, int p, int[] arrA) {
		if (p==W) {
			if (!found) {
				found = true;
				ans = Arrays.copyOf(arrA, 6);
			}
			
			return;
		}
		
		if (p>W || cnt==-1 || found) 
			return;
		
		for (int i = arr[cnt]; i >= 0; i--) {
			arrA[cnt] = i;
			recur(cnt-1,
					p+i*(cnt==5 ? 1 :
						(cnt==4 ? 5 :
							(cnt==3 ? 10 :
								(cnt==2 ? 50 :
									(cnt==1 ? 100 : 500)))))
					,arrA);
		}
	}

}

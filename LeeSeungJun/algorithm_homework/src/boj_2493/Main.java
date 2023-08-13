package boj_2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int[] arr = new int[N];
		int[] ansarr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			int p = 0;
			while (!stack.empty() && (arr[(p=stack.peek())]) <= arr[i]) {
				stack.pop();
			}
			
			if (stack.empty()) {
				ansarr[i] = 0;
				stack.push(i);
			} else {
				ansarr[i] = p+1;
				stack.push(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ansarr[i]).append(' ');
		}
		System.out.println(sb);
	}

}

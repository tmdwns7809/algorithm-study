package boj_11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int b = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "add":
				b |= 1 << Integer.parseInt(st.nextToken());
				break;
				
			case "remove":
				b &= (-1 ^ (1 << Integer.parseInt(st.nextToken())));
				break;
				
			case "check":
				sb.append(((b & (1 << Integer.parseInt(st.nextToken()))) != 0) ? 1 : 0).append('\n');
				break;
				
			case "toggle":
				b ^= 1 << Integer.parseInt(st.nextToken());
				break;
				
			case "all":
				b = -1;
				break;
				
			case "empty":
				b = 0;
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}

}

//boj 11724 비트마스킹
//boj 2961, 12891 부분집합
//boj 2023 아이디어
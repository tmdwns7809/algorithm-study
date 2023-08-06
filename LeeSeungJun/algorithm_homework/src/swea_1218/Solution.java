package swea_1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			char[] sarr = new char[N];
			int ans = 1;
			int idx = 0;
			mainloop: for (int i = 0; i < N; i++) {
				sarr[idx] = arr[i];
				
				switch (sarr[idx]) {
				case ')':
					if (idx==0 || sarr[idx-1] != '(') {
						ans = 0;
						break mainloop;
					}
					idx-=2;
					break;
				case ']':
					if (idx==0 || sarr[idx-1] != '[') {
						ans = 0;
						break mainloop;
					}
					idx-=2;
					break;
				case '}':
					if (idx==0 || sarr[idx-1] != '{') {
						ans = 0;
						break mainloop;
					}
					idx-=2;
					break;
				case '>':
					if (idx==0 || sarr[idx-1] != '<') {
						ans = 0;
						break mainloop;
					}
					idx-=2;
					break;

				default:
					break;
				}
				
				idx++;
			}
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

}

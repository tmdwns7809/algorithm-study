package week5.day4.boj17281;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[] p = new int[9];
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		p[3] = 0;
		
		dfs(0,1);
		
		System.out.println(ans);
	}
	
	static void dfs(int cnt, int v) {
		if (cnt==9) {
			int now = 0;
			int cb = 0;
			for (int i = 0; i < N; i++) {
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(0);
				q.add(0);
				q.add(0);
				int out = 0;
				while (true) {
					if (arr[i][p[cb]]==0) out++;
					else {
						q.add(1);
						for (int j = 0; j < arr[i][p[cb]]-1; j++) {
							q.add(0);
						}
						while(q.size()>3) {
							now += q.poll();
						}
					}
					cb=(cb+1)%9;
					
					if (out > 2) break;
				}
			}
			if (now > ans) ans = now;
		}
		
		for (int i = 0; i < 9; i++) {
			if (cnt==3) {
				if (i>0) break;
			} else if ((v&1<<i)!=0) continue;
			
			p[cnt] = i;
			dfs(cnt+1, v|1<<i);
		}
	}

}

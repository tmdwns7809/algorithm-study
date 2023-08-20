package week4.day5.boj2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		List<Integer>[] arr = new LinkedList[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (arr[a]==null) arr[a] = new LinkedList<>();
			if (arr[b]==null) arr[b] = new LinkedList<>();
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		boolean[] v = new boolean[n+1];
		
		q.add(new int[] {s,0});
		v[s] = true;
		
		int ans = -1;
		while (!q.isEmpty()) {
			int[] p = q.poll();
			
			if (p[0]==e) {
				ans = p[1];
				break;
			}
			
			for (int i : arr[p[0]]) {
				if (v[i]) continue;
					
				v[i] = true;
				q.add(new int[] {i,p[1]+1});
			}
		}
		
		System.out.println(ans);
	}

}

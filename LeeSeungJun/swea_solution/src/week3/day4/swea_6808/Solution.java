package week3.day4.swea_6808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int aw;
	static int bw;
	static int[] a;
	static int[] b;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("s_input.txt").getFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			a = new int[9];
			b = new int[9];
			int[] c = new int[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				c[a[i]] = 1;
			}
			int bi = 0;
			for (int i = 1; i < 19; i++) {
				if (c[i] == 0) {
					b[bi++] = i;
				}
			}
			
			aw = 0;
			bw = 0;
			
			per(0, 0, 0, 0);
			
			System.out.printf("#%d %d %d%n", t, aw, bw);
		}
	}
	
	static void per(int cnt, int as, int bs, int v) {
		if (cnt == 9) {
			if (as > bs) aw++;
			else if (bs > as) bw++;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if ((v&(1<<i))!=0) continue;
			
			int p = a[cnt] + b[i];
			if (a[cnt]>b[i]) per(cnt+1, as+p, bs, v|(1<<i));
			else per(cnt+1, as, bs+p, v|(1<<i));
		}
	}

}

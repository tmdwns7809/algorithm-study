package week4.day4.swea_5644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(Solution.class.getResource("sample_input.txt").getFile()));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] aR = new int[M+1];
			int[] bR = new int[M+1];
			aR[0] = 0;
			bR[0] = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				aR[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				bR[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] ap = new int[A][4];
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				ap[i][0] = Integer.parseInt(st.nextToken());
				ap[i][1] = Integer.parseInt(st.nextToken());
				ap[i][2] = Integer.parseInt(st.nextToken());
				ap[i][3] = Integer.parseInt(st.nextToken());
			}
			
			int[] aP = {1,1};
			int[] bP = {10,10};
			
			int[] dx = {0,0,1,0,-1};
			int[] dy = {0,-1,0,1,0};
			
			int ans = 0;
			for (int i = 0; i < M+1; i++) {
				aP[0] += dx[aR[i]];
				aP[1] += dy[aR[i]];
				bP[0] += dx[bR[i]];
				bP[1] += dy[bR[i]];
				
				int sumBig = 0;
				for (int j = 0; j < A; j++) {
					for (int j2 = 0; j2 < A; j2++) {
						int sum = 0;
						
						boolean aIn = 
								(Math.abs(aP[0]-ap[j][0]) 
										+ Math.abs(aP[1]-ap[j][1])) <= ap[j][2];
						boolean bIn = 
								(Math.abs(bP[0]-ap[j2][0]) 
										+ Math.abs(bP[1]-ap[j2][1])) <= ap[j2][2];
						
						if (aIn && bIn && j==j2) {
							sum = ap[j][3]/2;
						} else {
							if (aIn)
								sum = ap[j][3];
							if (bIn)
								sum += ap[j2][3]; 
						}
						
						if (sum > sumBig)
							sumBig = sum;
					}
				}
				
				ans += sumBig;
			}
			
			System.out.printf("#%d %d%n", t, ans);
			
		}
	}

}

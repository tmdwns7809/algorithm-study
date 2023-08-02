package solution_SWEA_1868;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Pos{
	int r;
	int c;
	
	public Pos(int r, int c) {
		this.r=r;
		this.c=c;
	}
}
class Solution
{
	static int[] dirC= {-1,-1,0,1,1,1,0,-1};
	static int[] dirR= {0,-1,-1,-1,0,1,1,1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			int N=sc.nextInt();
			
			char[][] map=new char[N][N];
			for(int i=0;i<N;i++) {
				map[i]=sc.next().toCharArray();
				for(int j=0;j<N;j++) {
					if(map[i][j]=='.') {
						map[i][j]='0';
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='*') {
						for(int k=0;k<dirR.length;k++) {
							int dR=i+dirR[k];
							int dC=j+dirC[k];
							
							if(dR>=0 && dR<N && dC>=0 && dC<N
								&& map[dR][dC]!='*') {
								map[dR][dC]='.';
							}
						}
					}
				}
			}
			
			boolean[][] visited=new boolean[N][N];
			int ans=0;
			

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j]=='0') {
						ans++;
						
						Queue<Pos> q=new LinkedList<Pos>();
						q.add(new Pos(i,j));
						visited[i][j]=true;
						
						while(!q.isEmpty()) {
							Pos p=q.poll();
							
							for(int k=0;k<dirR.length;k++) {
								int dR=p.r+dirR[k];
								int dC=p.c+dirC[k];
								
								if(dR>=0 && dR<N && dC>=0 && dC<N
									&& !visited[dR][dC] && map[dR][dC]!='*') {
									visited[dR][dC]=true;
									if(map[dR][dC]=='0') {
										q.add(new Pos(dR,dC));
									}
								}
							}
						}
					}
				}
			}
			

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j]!='*') {
						visited[i][j]=true;
						ans++;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}
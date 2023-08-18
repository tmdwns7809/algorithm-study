package week4.day5.boj_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M; //행,열갯수
	static int[][] map;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];
		res = Integer.MAX_VALUE;
		String s;
		for(int i = 0; i < N ; i++) {
			s = sc.next();
			for(int j = 0; j < M ;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs();
		
		System.out.println(res);
	}
	static int[] dx = {0,0,-1,1};  //상하좌우
	static int[] dy = {-1,1,0,0};
	static boolean[][] v;
	private static void bfs() {
		
		Queue<Data> q = new LinkedList();
		
		q.offer(new Data(0,0,1));
		v[0][0] = true;
		Data cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(cur.x == M-1  && cur.y == N-1) {
				res = cur.cnt;
				break;
			}
			int nx, ny;
			for(int d = 0; d < 4; d++) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				if(nx  < 0 || nx >= M || ny < 0 || ny >= N) {
					continue;
				}
				if(v[ny][nx]) {
					continue;
				}
				
				if(map[ny][nx] == 0) {
					continue;
				}
				q.offer(new Data(nx, ny, cur.cnt + 1));
				v[ny][nx] = true;
			}
		}
		
	}
	static class Data{
		int x, y;
		int cnt;
		public Data(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
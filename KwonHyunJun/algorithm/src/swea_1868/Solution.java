package swea_1868;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N; // 배열의 크기
	static char[][] map;
	static int click;

	// 방향
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 }; // 첫번째
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 }; // 두번째

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테케 사이즈

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			// ---------------------------------Input End---------------------------------
			click = 0;
			bfs(); 
			System.out.println(click);
			for(char[] c : map) {
				System.out.println(Arrays.toString(c));
			}

		}

	}

	static void bfs() {
		Queue<Loc> q = new ArrayDeque<>(); // 1. 큐 객체 생성

		// 시작 시점 넣기
		for (int i = 0; i < N; i++) { // 전체 순회
			for (int j = 0; j < N; j++) { 
				if (map[i][j] == '.' && search(i, j) < 8) { // 해당자리에 지뢰가 없고 근처에 지뢰가 없다면 시작 시점으로
					map[i][j] = 0; 
					q.offer(new Loc(i, j));
					click++; 
					
					while(!q.isEmpty()) {
						Loc loc = q.poll(); 
						
						for (int k = 0; k < 8; k++) {
							int nextX = loc.x + dx[i]; 
							int nextY = loc.y + dy[i];	
							if (nextX < 0 || nextX > N || nextY < 0 || nextY > N) continue;
							map[nextX][nextY] = (char) search(nextX, nextY);
							if(map[nextX][nextY] == '0') {
								q.offer(new Loc(nextX, nextY)); 
							}
							
						}
						
					}
				}
			}
		}
		
		

	}

	// 주위 살피면서
	static int search(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];  
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
			if (map[nextX][nextY] == '*') { // 만약 근처에 지뢰가 있다면
				cnt++;
			}
		}
		return cnt;

	}

}

class Loc {
	int x;
	int y;

	public Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

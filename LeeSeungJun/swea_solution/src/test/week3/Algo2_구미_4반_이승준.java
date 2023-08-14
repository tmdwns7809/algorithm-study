package test.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_구미_4반_이승준 {

	public static void main(String[] args) throws Exception {
		
		// 입력객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 횟수 T 읽기
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 횟수만큼 반복
		for (int t = 1; t <= T; t++) {
			// 종이컵의 수 N 읽기
			int N = Integer.parseInt(br.readLine());
			
			// 맵을 읽기 위한 2차원 배열 생성
			char[][] map = new char[N][N];
			
			// 2차원 맵 중 행 읽기
			for (int i = 0; i < N; i++) {
				// 한 줄의 입력들을 구분하기 위한 객체 생성
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				// 2차원 맵 중 열 읽기
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			// 총 이동 가능한 횟수
			int ans = 0;

			// 2차원 맵 중 행을 탐색하며 각 로봇별 이동 가능위치 구하기
			for (int i = 0; i < N; i++) {
				// 2차원 맵 중 열을 탐색하며 각 로봇별 이동 가능위치 구하기
				for (int j = 0; j < N; j++) {
					// 맵의 현재 위치에 할당된 값에 따른 다른 동작들을 나타내기 위한 switch문
					switch (map[i][j]) {
					// A로봇인 경우
					case 'A':
						// A 로봇의 다음 이동 거리
						int dA = 1;
						// 다음 이동 위치가 이동가능하다면 거리증가 반복
						while (j+dA < N && map[i][j+dA] == 'S') {
							// 거리 증가
							dA++;
						}
						
						// dA는 다음 이동 거리이기 때문에 현재 이동한 거리는 거기서 1을 빼준값이다
						// 그것을 더하면 현재까지 총 이동 가능횟수이다
						ans += dA-1;
						break;

						// A로봇인 경우
					case 'B':
						// B 로봇의 다음 위 이동 거리
						int dB1 = 1;
						// 다음 이동 위치가 이동가능하다면 거리증가 반복
						while (i-dB1 >= 0 && map[i-dB1][j] == 'S') {
							// 거리 증가
							dB1++;
						}
						
						// B 로봇의 다음 아래 이동 거리
						int dB2 = 1;
						// 다음 이동 위치가 이동가능하다면 거리증가 반복
						while (i+dB2 < N && map[i+dB2][j] == 'S') {
							// 거리 증가
							dB2++;
						}

						// dB1, dB2는 다음 이동 거리이기 때문에 현재 이동한 거리는 거기서 1을 빼준값이다
						// 그것을 더하면 현재까지 총 이동 가능횟수이다
						ans += (dB1-1) + (dB2-1);
						break;

						// A로봇인 경우
					case 'C':
						// C 로봇의 다음 왼쪽위 이동 거리
						int dC1 = 1;
						// 다음 이동 위치가 이동가능하다면 거리증가 반복
						while (i-dC1>=0 && j-dC1>=0 && map[i-dC1][j-dC1] == 'S') {
							// 거리 증가
							dC1++;
						}
						
						// C 로봇의 다음 오른쪽위 이동 거리
						int dC2 = 1;
						// 다음 이동 위치가 이동가능하다면 거리증가 반복
						while (i-dC2>=0 && j+dC2<N && map[i-dC2][j+dC2] == 'S') {
							// 거리 증가
							dC2++;
						}
						
						// C 로봇의 다음 왼쪽아래 이동 거리
						int dC3 = 1;
						// 다음 이동 위치가 이동가능하다면 거리증가 반복
						while (i+dC3<N && j-dC3>=0 && map[i+dC3][j-dC3] == 'S') {
							// 거리 증가
							dC3++;
						}
						
						// C 로봇의 다음 오른쪽아래 이동 거리
						int dC4 = 1;
						// 다음 이동 위치가 이동가능하다면 거리증가 반복
						while (i+dC4<N && j+dC4<N && map[i+dC4][j+dC4] == 'S') {
							// 거리 증가
							dC4++;
						}

						// dC1, dC2, dC3, dC4는 다음 이동 거리이기 때문에 현재 이동한 거리는 거기서 1을 빼준값이다
						// 그것을 더하면 현재까지 총 이동 가능횟수이다
						ans += (dC1-1) + (dC2-1) + (dC3-1) + (dC4-1);
						break;
					}
				}
			}

			// 답 출력
			System.out.printf("#%d %d%n", t, ans);
		}
	}

}

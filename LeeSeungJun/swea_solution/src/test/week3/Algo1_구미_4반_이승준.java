import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_4반_이승준 {

	public static void main(String[] args) throws Exception {
		
		// 입력객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 횟수 T 읽기
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 횟수만큼 반복
		for (int t = 1; t <= T; t++) {
			// 한 줄의 입력들을 구분하기 위한 객체 생성
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 종이컵의 수 N 읽기
			int N = Integer.parseInt(st.nextToken());

			// 첫 간식 위치 X 읽기
			int X = Integer.parseInt(st.nextToken());

			// 컵 교환 횟수 K 읽기
			int K = Integer.parseInt(st.nextToken());
			
			// 교환 횟수만큼 반복
			for (int i = 0; i < K; i++) {
				// 한 줄의 입력들을 구분하기 위한 객체 생성
				st = new StringTokenizer(br.readLine());
				
				// 첫번째 교환 위치 읽기
				int c1 = Integer.parseInt(st.nextToken());
				// 두번째 교환 위치 읽기
				int c2 = Integer.parseInt(st.nextToken());
				
				// c1이 현재 간식의 위치라면 간식의 위치는 c2로 변경되고
				// c2이 현재 간식의 위치라면 간식의 위치는 c1로 변경되고
				// 둘 다 아니라면 그대로 유지된다
				X = c1==X ? c2 : (c2==X ? c1 : X);
			}
			
			// 답 출력
			System.out.printf("#%d %d%n", t, X);
		}
	}

}

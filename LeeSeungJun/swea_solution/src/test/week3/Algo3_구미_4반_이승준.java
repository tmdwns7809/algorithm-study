package test.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo3_구미_4반_이승준 {

	public static void main(String[] args) throws Exception {
		
		// 입력객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// k 읽기
		int k = Integer.parseInt(br.readLine());
		
		// 문자 읽기
		char[] arr = br.readLine().toCharArray();
		
		// 마지막 가로 접기
		char lastG = 0;
		// 마지막 세로 접기
		char lastS = 0;
		// 마지막 가로접기와 세로접기가 무엇인지 저장한다
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'R' || arr[i] == 'L') {
				lastG = arr[i];
			} else if (arr[i] == 'U' || arr[i] == 'D') {
				lastS = arr[i];
			}
		}
		
		// 구멍 위치 h 읽기
		int h = Integer.parseInt(br.readLine());
		
		// 최종 배치 상태
		int[][] ans = new int[2][2];
		
		// 마지막 접었을때의 배치가 계속 반복되는 형태이기 때문에
		// 최종 배치상태만 구하면 그 뒤에는 그 배치를 반복해서 출력하기만 하면 된다
		if (lastG == 'R' && lastS == 'D') {
			ans = new int[][]{{opoG(opoS(h)),opoS(h)},{opoG(h),h}};
		} else if (lastG == 'R' && lastS == 'U') {
			ans = new int[][]{{opoG(h),h},{opoG(opoS(h)),opoS(h)}};
		} else if (lastG == 'L' && lastS == 'D') {
			ans = new int[][]{{opoS(h),opoG(opoS(h))},{h,opoG(h)}};
		} else {
			ans = new int[][]{{h,opoG(h)},{opoS(h),opoG(opoS(h))}};
		}
		
		// 종이의 크기만큼 반복하여 출력한다
		int len = (int)Math.pow(2, k);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				sb.append(ans[i%2][j%2]).append(' ');
			}
			sb.append('\n');
		}
		
		// 답 출력
		System.out.println(sb);
	}
	
	// 가로 대칭의 값을 구하는 메소드
	static int opoG(int a) {
		if (a == 3)
			return 2;
		else if (a==2)
			return 3;
		else if (a==1)
			return 0;
		else
			return 1;
	}
	

	// 세로 대칭의 값을 구하는 메소드
	static int opoS(int a) {
		if (a == 3)
			return 1;
		else if (a==2)
			return 0;
		else if (a==1)
			return 3;
		else
			return 2;
	}

}

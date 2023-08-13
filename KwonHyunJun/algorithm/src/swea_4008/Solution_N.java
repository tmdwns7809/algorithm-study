package swea_4008;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_N {
	static int N; 						// 숫자 개수
	static int[] opersCnt = new int[4]; // 연산자 개수
	static int[] nums; 					// 입력받은 숫자
	static List<Integer> opers; 					// 연산자 결과값
	
	static boolean[] isSelected;
	static int[] res; 
	
	static int max;
	static int min; 

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\SStudy\\algo_homework\\src\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테케 사이즈

		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE; 
			min  = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); 
			nums = new int[N];
			opers = new ArrayList<>();
			res = new int[N-1]; 
			isSelected = new boolean[N-1]; 

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				opersCnt[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken()); 
			}
			//------------------------------------Input End-------------------
			
			// 연산자 배열 만들기
			for(int i=0; i<4; i++) {
				int tempCnt = opersCnt[i]; 
				for(int j=0;j<tempCnt;j++) {
					opers.add(i); 
				}
			}
						
			perm(0);  
			sb.append("#").append(test_case).append(" ").append(Math.abs(min-max)).append("\n");
		}

		System.out.println(sb);
	}
	
	public static void perm(int cnt) {
		if(cnt == N-1) {
			int prev = nums[0];
			
			for(int i=0;i<N-1;i++) {
				int next = nums[i+1]; 
				switch(res[i]) {
					case 0: {
						prev = prev + next; 
						break;
					}
					case 1: {
						prev = prev - next;
						break;
					}
					case 2: {
						prev = prev * next;
						break;
					}
					case 3: {
						prev = prev / next;
						break;
					}
				}
			}
			
			if(prev > max) max = prev; 
			if(prev < min) min = prev;
			
			return; 
		}
		
		// TODO : 자리들어가는 원소 선택
		for(int i=0;i<N-1;i++) {
			if(isSelected[i] == true)continue;
			res[cnt] = opers.get(i);
			isSelected[i] = true; 
			perm(cnt+1); 
			isSelected[i] = false; 
		}
		
	}

}

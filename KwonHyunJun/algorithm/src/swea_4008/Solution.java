package swea_4008;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.omg.CORBA.PERSIST_STORE;

// 4008 숫자 만들기
public class Solution {	
	static int N; // 연산 숫자 개수
	static int[] opers = new int[4], nums; // 연산자 개수, 사용되는 숫자
	static int min, max; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테케 사이즈

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N]; 
//			v = new boolean[N-1]; 
			
			st =  new StringTokenizer(br.readLine()); 
			for(int i=0;i<4;i++) {
				opers[i] = Integer.parseInt(st.nextToken()); 
			}
			st =  new StringTokenizer(br.readLine()); 
			for(int i=0; i<N;i++) {
				nums[i] = Integer.parseInt(st.nextToken()); 
			}
			// ---------------------------------Input End---------------------------------
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE; 
			
			perm(0, new int[N-1]); 
			
			System.out.printf("#%d %d\n",test_case,max - min);
			
		}
	}
	/**
	 * 연산자 순열 만들기
	 * @param cnt : 현재 고려되고 있는 연산자 자리
	 */
	static void perm(int cnt, int[] operSelect) {
		if(cnt == N-1) {
			int res = calc(operSelect);
			
			min = Math.min(min, res);
			max = Math.max(max, res);
			
			return; 
		}
		
		for(int i=0; i<4; i++) {
			if(opers[i] >0) {
				operSelect[cnt] = i; // 뽑은 연산자 번호 넣기 
				opers[i]--; 
				perm(cnt+1, operSelect);
				opers[i]++; 
			}
		}
		
	}
	
	static int calc(int[] operSelect) {
		int num = nums[0]; 
		for(int i=0; i < operSelect.length; i++) {
			int oper = operSelect[i];
			if(oper == 0) {
				num +=nums[i+1]; 
			}else if(oper == 1){
				num -=nums[i+1]; 
			}else if(oper == 2){
				num *=nums[i+1]; 
			}else {
				num /=nums[i+1]; 
				
			}
		}
		return num;
	}

}

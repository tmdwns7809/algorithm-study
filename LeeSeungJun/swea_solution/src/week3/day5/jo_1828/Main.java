package week3.day5.jo_1828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Data[] arr = new Data[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		int lastEnd = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].low > lastEnd) {
				ans++;
				lastEnd = arr[i].high;
			}
		}
		
		System.out.println(ans);
	}

}

class Data implements Comparable<Data> {
	int low;
	int high;
	
	Data(int low, int high) {
		this.low = low;
		this.high = high;
	}

	@Override
	public int compareTo(Data o) {
		if (high==o.high)
			return this.low-o.low;
		else
			return this.high-o.high;
	}
	
}

// 2023-08-11 14:03
package week3.day5.boj_1931;

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
		int lastEnd = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i].start>=lastEnd) {
				ans++;
				lastEnd = arr[i].end;
			}
		}
		
		System.out.println(ans);
	}

}

class Data implements Comparable<Data> {
	int start;
	int end;
	
	Data(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Data o) {
		if (this.end==o.end)
			return this.start-o.start;
		else
			return this.end-o.end;
	}
	
}

// 2023-08-11 14:49
// 2023-08-11 15:27
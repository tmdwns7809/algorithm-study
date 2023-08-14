package week3.day5.boj_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static List<Pos> hlist;
	static List<Pos> clist;
	static List<Pos> clist2;
	static int ans;

<<<<<<< HEAD
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

=======
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		hlist = new ArrayList<Pos>();
		clist = new ArrayList<Pos>();
		clist2 = new ArrayList<Pos>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n==1) {
					hlist.add(new Pos(i,j));
				} else if (n==2) {
					clist.add(new Pos(i,j));
					clist2.add(null);
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		recur(0,0);
		
		System.out.println(ans);
	}
	
	static void recur(int cnt, int start) {
		if (cnt == M) {
			int city = 0;
			for (int i = 0; i < hlist.size(); i++) {
				int h = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int d = Math.abs(hlist.get(i).r-clist2.get(j).r) + Math.abs(hlist.get(i).c-clist2.get(j).c);
					if (d < h) {
						h = d;
					}
				}
				city += h;
			}
			if (city < ans) {
				ans = city;
			}
			return;
		}
		
		for (int i = start; i < clist.size(); i++) {
			clist2.set(cnt, clist.get(i));
			recur(cnt+1, i+1);
		}
>>>>>>> ff983a79bfa86b12115646cdd0679d8e3413f047
	}
}

class Pos {
	int r;
	int c;
	
	Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
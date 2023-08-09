package week3.boj_11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if (list.size() == 1) {
					sb.append(0);
				} else {
					sb.append(list.get(1));
					list.set(1, list.get(list.size()-1));
					list.remove(list.size()-1);
//					int parent = 1;
//					int child;
//					while (true) {
//						child = parent*2;
//						if (child+1<list.size() 
//								&& (Math.abs(list.get(child+1)) < Math.abs(list.get(child)) 
//								|| (Math.abs(list.get(child+1))==Math.abs(list.get(child)) 
//										&& list.get(child+1)<list.get(child)))) {
//							child++;
//						}
//						
//						if (child >= list.size() 
//								|| (Math.abs(list.get(parent)) < Math.abs(list.get(child)) 
//										|| (Math.abs(list.get(parent))==Math.abs(list.get(child)) 
//											&& list.get(parent)<list.get(child)))) {
//							break;
//						}
//
//						int temp = list.get(parent);
//						list.set(parent, list.get(child));
//						list.set(child, temp);
//						
//						parent = child;
//					}

					int idx = 1;
					while (true) {
						int min = Math.abs(list.get(idx));
						int cIdx = idx;
						int leftIdx = idx*2;
						int rightIdx = leftIdx + 1;
						if (leftIdx < list.size()) {
							if (Math.abs(list.get(leftIdx)) < min
									|| (Math.abs(list.get(leftIdx))==min 
									&& list.get(leftIdx)<list.get(idx))) {
								min = Math.abs(list.get(leftIdx));
								cIdx = leftIdx;
							}
						}
						if (rightIdx < list.size()) {
							if (Math.abs(list.get(rightIdx)) < min
									|| (Math.abs(list.get(rightIdx))==min 
									&& list.get(rightIdx)<list.get(idx))) {
								min = Math.abs(list.get(rightIdx));
								cIdx = rightIdx;
							}
						}
						
						if (idx == cIdx) {
							break;
						} else {
							int temp = list.get(idx);
							list.set(idx, list.get(cIdx));
							list.set(cIdx, temp);
							
							idx = cIdx;
						}
					}
				}
				sb.append('\n');
			} else {
				list.add(n);
				int idx = list.size()-1;
				
				while (idx>1
						&& (Math.abs(n) < Math.abs(list.get(idx/2)) 
								|| (Math.abs(n)==Math.abs(list.get(idx/2)) 
										&& n<list.get(idx/2)))) {
					list.set(idx, list.get(idx/2));
					idx /= 2;
				}
				list.set(idx, n);
				
//				while (true) {
//					int max = Math.abs(list.get(idx));
//					int cIdx = idx;
//					int pIdx = idx/2;
//					if (Math.abs(list.get(pIdx)) > max
//							|| (Math.abs(list.get(pIdx))==max 
//							&& list.get(pIdx)>list.get(idx))) {
//						cIdx = pIdx;
//					}
//					
//					if (idx == cIdx) {
//						break;
//					} else {
//						int temp = list.get(idx);
//						list.set(idx, list.get(cIdx));
//						list.set(cIdx, temp);
//						
//						idx = cIdx;
//					}
//				}
			}
		}
		System.out.println(sb);
	}

}
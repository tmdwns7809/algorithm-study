package solution_SWEA_5550;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{

			/////////////////////////////////////////////////////////////////////////////////////////////
			
			char[] arr = sc.next().toCharArray();
			
			int ans = 0;
			List<List<Character>> croaks = new LinkedList<List<Character>>();
			
			for (int i = 0; i < arr.length; i++) {
				if (croaks.size() == 0) {
					if (arr[i] == 'c') {
						croaks.add(new LinkedList<Character>());
						croaks.get(croaks.size() - 1).add(arr[i]);
						ans++;
					} else {
						ans = -1;
						break;
					}
				} else {
					boolean found = false;
					for (int j = 0; j < croaks.size(); j++) {
						char last = croaks.get(j).get(croaks.get(j).size() - 1);
						if ((last == 'c' && arr[i] == 'r') || (last == 'r' && arr[i] == 'o')
								|| (last == 'o' && arr[i] == 'a') || (last == 'a' && arr[i] == 'k')
								|| (last == 'k' && arr[i] == 'c')) {
							found = true;

							croaks.get(j).add(arr[i]);
							
							break;
						}
					}
					if (!found) {
						if (arr[i] == 'c') {
							croaks.add(new LinkedList<Character>());
							croaks.get(croaks.size() - 1).add(arr[i]);
							ans++;
						} else {
							ans = -1;
							break;
						}
					}
				}
			}
			
			for (int j = 0; j < croaks.size(); j++) {
				if (croaks.get(j).get(croaks.get(j).size() - 1) != 'k') {
					ans = -1;
					break;
				}
			}
			
			System.out.printf("#%d %d%n", test_case, ans);
			
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}

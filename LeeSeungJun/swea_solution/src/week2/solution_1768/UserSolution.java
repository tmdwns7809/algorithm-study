package week2.solution_1768;

class UserSolution {
    public final static int N = 4;

    public void doUserImplementation(int guess[]) {
        // Implement a user's implementation function
        //
        // The array of guess[] is a return array that
        // is your guess for what digits[] would be.
    	
    	int[] num = new int[10*9*8*7];
    	boolean[] p = new boolean[9877];
    	
    	int idx = 0;
    	for (int i = 0123; i < 9877; i++) {
			int n1 = i%10;
			int n2 = i/10%10;
			int n3 = i/100%10;
			int n4 = i/1000;
			
			if (n1!=n2 && n1!=n3 && n1!=n4 && n2!=n3 && n2!=n4 && n3!=n4) {
				num[idx] = i;
				idx++;
				p[i] = true;
			}
		}
    	
    	for (int i = 0; i < num.length; i++) {
    		if (!p[num[i]]) {
    			continue;
    		}

			guess[3] = num[i]%10;
			guess[2] = num[i]/10%10;
			guess[1] = num[i]/100%10;
			guess[0] = num[i]/1000;
			boolean[] v = new boolean[10];
			v[guess[0]] = true;
			v[guess[1]] = true;
			v[guess[2]] = true;
			v[guess[3]] = true;
			
			Solution.Result r = Solution.query(guess);
			
			if (r.strike == 4) {
				return;
			} else {
				p[num[i]] = false;
				for (int j = i+1; j < num.length; j++) {
		    		if (!p[num[j]]) {
		    			continue;
		    		}

					int guess2[] = {num[j]/1000,num[j]/100%10,num[j]/10%10,num[j]%10};
					int strike = 0;
					int ball = 0;

					for (int d = 0; d < N; ++d) {
						if (guess[d] == guess2[d])
							strike++;
						else if (v[guess2[d]])
							ball++;
					}
					
					if (r.strike != strike || r.ball != ball) {
						p[num[j]] = false;
					}
				}
			}
		}
    }
}

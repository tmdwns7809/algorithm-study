package b.week1.swea_13072;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static long initTime = 0;
    public static long hireTime = 0;
    public static long fireTime = 0;
    public static long updateSoldierTime = 0;
    public static long updateTeamTime = 0;
    public static long bestSoldierTime = 0;
    public static long start;

	private final static int CMD_INIT				= 1;
	private final static int CMD_HIRE				= 2;
	private final static int CMD_FIRE				= 3;
	private final static int CMD_UPDATE_SOLDIER		= 4;
	private final static int CMD_UPDATE_TEAM		= 5;
	private final static int CMD_BEST_SOLDIER		= 6;
	
	private final static UserSolution_Mine usersolution = new UserSolution_Mine();
	
	private static boolean run(BufferedReader br) throws Exception
	{
		StringTokenizer st;
		
		int numQuery;

		int mID, mTeam, mScore, mChangeScore;
	
		int userAns, ans;
	
		boolean isCorrect = false;

		numQuery = Integer.parseInt(br.readLine());
		
		for (int q = 0; q < numQuery; ++q)
		{
			st = new StringTokenizer(br.readLine(), " ");

			int cmd;
			cmd = Integer.parseInt(st.nextToken());
			
			switch(cmd)
			{
			case CMD_INIT:
		    	start = System.currentTimeMillis();
				usersolution.init();
				isCorrect = true;
		        initTime += System.currentTimeMillis() - start;
				break;
			case CMD_HIRE:
		    	start = System.currentTimeMillis();
				mID = Integer.parseInt(st.nextToken());
				mTeam = Integer.parseInt(st.nextToken());
				mScore = Integer.parseInt(st.nextToken());
				usersolution.hire(mID, mTeam, mScore);
		        hireTime += System.currentTimeMillis() - start;
				break;
			case CMD_FIRE:
		    	start = System.currentTimeMillis();
				mID = Integer.parseInt(st.nextToken());
				usersolution.fire(mID);
		        fireTime += System.currentTimeMillis() - start;
				break;
			case CMD_UPDATE_SOLDIER:
		    	start = System.currentTimeMillis();
				mID = Integer.parseInt(st.nextToken());
				mScore = Integer.parseInt(st.nextToken());
				usersolution.updateSoldier(mID, mScore);
		        updateSoldierTime += System.currentTimeMillis() - start;
				break;
			case CMD_UPDATE_TEAM:
		    	start = System.currentTimeMillis();
				mTeam = Integer.parseInt(st.nextToken());
				mChangeScore = Integer.parseInt(st.nextToken());
				usersolution.updateTeam(mTeam, mChangeScore);
		        updateTeamTime += System.currentTimeMillis() - start;
				break;
			case CMD_BEST_SOLDIER:
		    	start = System.currentTimeMillis();
				mTeam = Integer.parseInt(st.nextToken());
				userAns = usersolution.bestSoldier(mTeam);
				ans = Integer.parseInt(st.nextToken());
				if (userAns != ans) {
					isCorrect = false;
				}
		        bestSoldierTime += System.currentTimeMillis() - start;
				break;
			default:
				isCorrect = false;
				break;
			}
		}
		
		return isCorrect;
	}
	
	public static void main(String[] args) throws Exception
	{
		int TC, MARK;
	
		System.setIn(new java.io.FileInputStream(Solution.class.getResource("sample_input.txt").getFile()));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
		}

//	    public static long initTime = 0;
//	    public static long hireTime = 0;
//	    public static long fireTime = 0;
//	    public static long updateSoldierTime = 0;
//	    public static long updateTeamTime = 0;
//	    public static long bestSoldierTime = 0;

        System.out.println("#initTime " + initTime);
        System.out.println("#hireTime " + hireTime);
        System.out.println("#fireTime " + fireTime);
        System.out.println("#updateSoldierTime " + updateSoldierTime);
        System.out.println("#updateTeamTime " + updateTeamTime);
        System.out.println("#bestSoldierTime " + bestSoldierTime);

		br.close();
	}
}
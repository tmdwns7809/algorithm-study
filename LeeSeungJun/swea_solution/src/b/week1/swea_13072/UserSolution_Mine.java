package b.week1.swea_13072;

import java.util.HashMap;

class UserSolution_Mine
{
	HashMap<Integer, Sol>[] team = new HashMap[6];
	
	public void init()
	{
		for (int i = 1; i < team.length; i++) {
			team[i] = new HashMap<>();
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		team[mTeam].put(mID, new Sol(mID, mScore));
	}
	
	public void fire(int mID)
	{
		for (int i = 1; i < team.length; i++) {
			team[i].remove(mID);
		}
	}

	public void updateSoldier(int mID, int mScore)
	{
		for (int i = 1; i < team.length; i++) {
			if (team[i].containsKey(mID)) {
				team[i].get(mID).mScore = mScore;
			}
		}
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		for (Sol s : team[mTeam].values()) {
			int c = s.mScore+mChangeScore;
			if (c > 5) {
				c = 5;
			} else if (c < 1) {
				c = 1;
			}
			s.mScore = c;
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		Sol maxS = null;
		for (Sol s : team[mTeam].values()) {
			if (maxS==null || s.mScore > maxS.mScore || (s.mScore==maxS.mScore && s.mID > maxS.mID)) {
				maxS = s;
			}
		}
		return maxS.mID;
	}
}

class Sol {
	int mID;
	int mScore;
	
	Sol(int mID, int mScore) {
		this.mID = mID;
		this.mScore = mScore;
	}
}
package Google;

public class _568_MaximumVacationDays {
	class Solution {
	    int totalc, totalw;
	    int max = Integer.MIN_VALUE;
	    public int maxVacationDays(int[][] flights, int[][] days) {
	        totalc = days.length;
	        totalw = days[0].length;
	        int[][] dp = new int[totalc][totalw];
	        for(int i = 0; i < totalc; i++) {
	            Arrays.fill(dp[i],-1);
	        }
	        return dfs(dp,flights,days,0,0);
	        
	    }
	    
	    int dfs(int[][] dp, int[][] flights, int[][] days, int weekno, int curr) {
	        if (weekno == totalw) {
	            return 0;
	        }
	        if (dp[curr][weekno] != -1) {
	            return dp[curr][weekno];
	        }
	        
	        dp[curr][weekno] = 0;
	        dp[curr][weekno] = days[curr][weekno] + dfs(dp,flights,days,weekno+1,curr); // stay
	        for(int i = 0; i < flights.length; i++) {
	            if (flights[curr][i] == 1) { // fly to city i
	               dp[curr][weekno] = Math.max(dp[curr][weekno], days[i][weekno] + dfs(dp,flights,days,weekno+1,i)); 
	            }
	        }
	        return dp[curr][weekno];
	    }
	}

}

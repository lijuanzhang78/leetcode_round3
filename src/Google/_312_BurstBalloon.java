package Google;

public class _312_BurstBalloon {
	class Solution {
	    public int maxCoins(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;
	        int n = nums.length + 2;
	        int[] inums = new int[n];
	        inums[0] = 1;
	        for(int i = 1; i <= nums.length; i++) {
	            inums[i] = nums[i-1];
	        }
	        inums[n-1] = 1;
	        
	        int[][] dp = new int[n][n];
	        for(int len = 1; len <= nums.length; len++) {
	            for(int left = 1; left+len-1 <= nums.length; left++) {
	                int right = left+len-1;
	                for(int i = left; i <= right; i++) {
	                    dp[left][right] = Math.max(dp[left][right],dp[left][i-1]+dp[i+1][right]+inums[left-1]*inums[i]*inums[right+1]); 
	                }
	            }
	        }
	        return dp[1][nums.length];
	    }
	}

}

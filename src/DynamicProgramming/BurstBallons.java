package DynamicProgramming;

public class BurstBallons {
	public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] Nums = new int[nums.length+2];
        Nums[0] = 1; Nums[nums.length+1] = 1;
        for(int i = 1; i < nums.length+1; i++) {
            Nums[i] = nums[i-1];
        }
        int[][] dp = new int[nums.length+2][nums.length+2];
        memoSearch(Nums,dp,1,nums.length);
        return dp[1][nums.length];
    }
    
    int memoSearch(int[] Nums, int[][] dp, int left, int right) {
        if (left > right) return 0;
        if (dp[left][right] > 0) return dp[left][right];
        for(int i = left; i <= right; i++) { // Nums[i] is the last number to burst
            dp[left][right] = Math.max(dp[left][right], memoSearch(Nums,dp,left,i-1) + memoSearch(Nums,dp,i+1,right) + Nums[left-1]*Nums[i]*Nums[right+1]);
        }
        return dp[left][right];
    }

}

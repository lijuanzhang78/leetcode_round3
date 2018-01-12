package DynamicProgramming;

// 对player 1 只要有一种选法能赢（return true）就是winner
// 对player 2（下一个选手）的调用，要把leftSum和rightSum的位置对调一下
// 这个解法无DP
// DP解法： dp[nums.length][nums.length]
// dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
//
public class PredictTheWinner {
	public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        if (nums.length <= 1) return true;
        return canWin(nums,0,0,0,nums.length-1);
    }
    
    boolean canWin(int[] nums, int leftSum, int rightSum, int start, int end) {
        if (start > end) {
            if (leftSum >= rightSum) {
                return true;
            } else {
                return false;
            }
        }
        
        // choose the start
        if(!canWin(nums,rightSum,leftSum+nums[start],start+1,end)) return true;
        // choose the end
        if (!canWin(nums,rightSum,leftSum+nums[end],start,end-1)) return true;
        return false;
    }
    
    
    // DP 解法
    //
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        
        for(int len = 2; len <= nums.length; len++) {
            for(int i = 0; i + len - 1 < nums.length; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

}

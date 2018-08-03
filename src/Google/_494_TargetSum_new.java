package Google;

public class _494_TargetSum_new {
	public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums,S,0);
    }
    
    int helper(int[] nums, int S, int pos) {
        if (pos == nums.length) {
            if (S == 0) return 1;
            return 0;
        }
        return helper(nums,S-nums[pos],pos+1) + helper(nums,S+nums[pos],pos+1);
    }

}

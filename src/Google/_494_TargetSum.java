package Google;

public class _494_TargetSum {
	int total = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        helper(nums,0,S,0);
        return total;
    }
    
    void helper(int[] nums, int curr, int S, int pos) {
        if (pos == nums.length) {
            if (curr == S) {
                total++;
            }
            return;
        }
        
        helper(nums,curr+nums[pos],S,pos+1);
        helper(nums,curr-nums[pos],S,pos+1);
    }

}

package DFS;

import java.util.Arrays;

// backtracking:
// 这道题借鉴了matchstickers to square，对于每个数字，有k种选择
// 需要把数字排下序，然后从大往小做选择,否则会超时
// 
public class PartitionToEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        int[] sums = new int[k];
        if (dfs(nums,k,sum/k,nums.length-1,sums)) return true;
        return false;
    }
    
    boolean dfs(int[] nums, int k, int target, int start, int[] sums) {
        for(int i = 0; i < k; i++) {
            if (sums[i] > target) return false;
        }
        if (start == -1) {
            for(int i = 0; i < k; i++) {
                if (sums[i] != target) return false;
            }
            return true;
        }
        
        for(int i = 0; i < k; i++) {
            sums[i] += nums[start];
            if(dfs(nums,k,target,start-1,sums)) return true;
            sums[i] -= nums[start];
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] nums = {4,3,2,3,5,2,1};
    	boolean res = new PartitionToEqualSumSubsets().canPartitionKSubsets(nums, 4);
    	return;
    }
}

package DFS;

import java.util.Arrays;

//
// 对于任意一只火柴，有4种选择，所以需要有4个dfs,可以从desicion tree来理解，每做一个决定，下一个决定有几种选择
// 就有几个branch
// 分清楚事情完成需要多少步（通过index--）和每一步有多少个选择（多少个dfs）
// 有一道具体算例，可以一步一步debug看看，更加深入理解dfs
// 复杂度是NP complete
//
public class MatchSticksToSquare {
	public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) return false;
        sum /= 4;
        Arrays.sort(nums);
        return dfs(nums,nums.length-1,sum,0,0,0,0);
    }
    
    boolean dfs(int[] nums, int start, int target, int sum1, int sum2, int sum3, int sum4) {
        if (sum1 > target || sum2 > target || sum3 > target || sum4 > target) return false;
        if (start == -1) {
            if (sum1 == target && sum2 == target && sum3 == target && sum4 == target) {
                return true;
            } else {
                return false;
            }    
        }
        
        if (dfs(nums,start-1,target,sum1+nums[start],sum2,sum3,sum4)) return true;
        if (dfs(nums,start-1,target,sum1,sum2+nums[start],sum3,sum4)) return true;
        if (dfs(nums,start-1,target,sum1,sum2,sum3+nums[start],sum4)) return true;
        if (dfs(nums,start-1,target,sum1,sum2,sum3,sum4+nums[start])) return true;
        
        return false;
    }
    
    public static void main(String[] args) {
    	int[] nums = {4,4,10,7,5,3,9,10,6,6,5,10,5,7,5};
    	boolean res = new MatchSticksToSquare().makesquare(nums);
    	return;	
    }
}

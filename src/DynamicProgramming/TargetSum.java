package DynamicProgramming;

// DFS 无DP
public class TargetSum {
	
	public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        
        return helper(nums,S,0,0);
    }
    
    int helper(int[] nums, int target, int pos, int sum) {
        if (pos == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        
        return helper(nums,target,pos+1,sum+nums[pos]) + helper(nums,target,pos+1,sum-nums[pos]);
    }
   
// DFS 无DP
//
    public int findTargetSumWays_2(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        Map<String,Integer> map = new HashMap<>();
        return helper(nums,S,0);
    }
    
    int helper_2(int[] nums, int target, int pos) {
        if (pos == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        //String currState = pos+"&"+
        
        return helper_2(nums,target-nums[pos],pos+1) + helper_2(nums,target+nums[pos],pos+1);
    }
    
// DFS + memorization  
//
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        Map<String,Integer> map = new HashMap<>();
        return helper(nums,S,0,map);
    }
    
    int helper(int[] nums, int target, int pos, Map<String,Integer> map) {
        if (pos == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        String currState = pos+"&"+target;
        if (map.containsKey(currState)) return map.get(currState);
        int res = helper(nums,target-nums[pos],pos+1,map) + helper(nums,target+nums[pos],pos+1,map);
        map.put(currState, res);
        return res;
    }

}

package DynamicProgramming;

// search with memo
// it can be done by the bottom-up approach
//
public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        helper(nums,target,map);
        return map.get(target);
    }
    
    int helper(int[] nums, int target, Map<Integer,Integer> map) {
        if (map.containsKey(target)) return map.get(target);
        
        if (target == 0) return 1;
        if (target < 0) return 0;
        int count = 0;
        for(int num : nums) {
            count += helper(nums,target-num,map);
        }
        map.put(target,count);
        return map.get(target);
    }

}

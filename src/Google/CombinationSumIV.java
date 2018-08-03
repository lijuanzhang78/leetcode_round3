package Google;

public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        dfs(map,nums,target);
        return map.get(target);
    }
    
    int dfs(Map<Integer,Integer> map, int[] nums, int target) {
        if (map.containsKey(target)) return map.get(target);
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if (target-nums[i] < 0) break;
            count += dfs(map,nums,target-nums[i]);
        }
        map.put(target,count);
        return count;
    }

}

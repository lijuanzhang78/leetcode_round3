package BackTracking;

// 注意去重： if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
// 在i位做选择的时候，如果（1）nums[i]已经添加过了，需要跳过
//                    (2) nums[i] 和 nums[i-1] 相等， 

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res,list,nums,visited,0);
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(res,list,nums,visited,pos+1);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

}

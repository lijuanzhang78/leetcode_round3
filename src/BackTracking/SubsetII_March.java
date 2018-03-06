package BackTracking;

// 位于同一层的连续相同元素 需要去重
public class SubsetII_March {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,res,list,0);
        return res;
    }
    
    void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<Integer>(list));
        if (start == nums.length) return;
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            helper(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }

}

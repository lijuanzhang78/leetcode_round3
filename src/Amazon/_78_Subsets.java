package Amazon;

public class _78_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(),res,nums,0);
        return res;
    }
    
    void helper(List<Integer> list, List<List<Integer>> res, int[] nums, int pos) {
        res.add(new ArrayList<Integer>(list));
        if (pos == nums.length) {
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(list,res,nums,i+1);
            list.remove(list.size()-1);
        }
    }

}

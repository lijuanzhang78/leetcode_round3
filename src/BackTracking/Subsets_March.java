package BackTracking;

public class Subsets_March {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        helper(nums,res,list,0);
        return res;
    }
    
    void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<Integer>(list));
        if (start == nums.length) return;
        
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
        return;
    }

}

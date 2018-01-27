package BackTracking;

// 排列组合问题：
// 完成这个任务，有nums.length个步骤，每个步骤有两个选择，选或者不选
// pos == nums.length 标志着一个任务的完成
//
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        helper(res,list,nums,0);
        return res;
    } 
    
    void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        list.add(nums[pos]);
        helper(res,list,nums,pos+1);
        list.remove(list.size()-1);
            
        helper(res,list,nums,pos+1);        
    }

}

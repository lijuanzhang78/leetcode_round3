package BackTracking;

// 用了hashset去重
// 细节：arraylist的建立可以用一个hashset作为参数
// new ArrayList<List<Integer>>(res); res is a hashset
//
public class SubsetII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        helper(nums,list,res,0);
        return new ArrayList<List<Integer>>(res);
    }
    
    void helper(int[] nums, List<Integer> list, Set<List<Integer>> res, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        list.add(nums[pos]);
        helper(nums,list,res,pos+1);
        list.remove(list.size()-1);
        
        helper(nums,list,res,pos+1);
        return;
    }

}

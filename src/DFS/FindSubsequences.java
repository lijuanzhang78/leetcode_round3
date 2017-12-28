package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,list,res,0);
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
    
    void dfs(int[] nums, List<Integer> list, Set<List<Integer>> res, int start) {
        if (list.size() >= 2) {
                res.add(new ArrayList<Integer>(list));
        }
        if (start == nums.length) return;
        for(int i = start; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                dfs(nums,list,res,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = {4, 6, 7, 7};
    	List<List<Integer>> res = new FindSubsequences().findSubsequences(nums);
    	
    }

}

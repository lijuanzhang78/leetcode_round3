package BackTracking;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(res,temp,candidates,0,target);
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (start == candidates.length) return;
        if (target < 0) return;
        
        for(int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res,list,candidates,i,target-candidates[i]);
            list.remove(list.size()-1);    
        }
    }

}

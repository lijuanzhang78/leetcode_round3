package BackTracking;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,list,res,0,target);
        return res;
    }
    
    void helper(int[] candidates, List<Integer> list, List<List<Integer>> res, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0) return;
        //if (start == candidates.length) return;
        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue; // avoid duplication
            list.add(candidates[i]);
            helper(candidates,list,res,i+1,target-candidates[i]);
            list.remove(list.size()-1);
        }
        return;
    }

}

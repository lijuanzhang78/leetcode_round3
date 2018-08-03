package Google;

public class _163_MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            getRange((long)lower-1,(long)upper+1,res);
        }
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > lower) {
                    getRange((long)lower-1,nums[i],res);
                }
            } else {
                if (nums[i] > nums[i-1]) {
                    getRange(nums[i-1],nums[i],res);
                }    
            }
        }
        if (nums.length > 0 && upper > nums[nums.length-1]) {
            getRange(nums[nums.length-1],(long)upper+1,res);
        }
        return res;
    }
    
    void getRange(long prev, long curr, List<String> res) {
        if (curr == prev+1) {
            return;
        } else if (curr == prev + 2) {
            res.add(""+(prev+1));
        } else {
            res.add((prev+1) + "->" + (curr-1));
        }
    }

}

package Google;

public class _228_SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                if (nums[i-1] != start) {
                    res.add(start+"->"+nums[i-1]);
                } else {
                    res.add(""+start);
                }
                start = nums[i];
            } 
        }
        if (start != nums[nums.length-1]) {
            res.add(start + "->" + nums[nums.length-1]);
        } else {
            res.add(""+start);
        }
        return res;
    }

}

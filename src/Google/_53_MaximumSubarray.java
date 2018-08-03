package Google;

public class _53_MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSofar = nums[0];
        int maxEndingHere = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxEndingHere = nums[i] + maxEndingHere;
            maxEndingHere = Math.max(nums[i],maxEndingHere);
            maxSofar = Math.max(maxSofar, maxEndingHere);    
        }
        return maxSofar;
        
    }

}

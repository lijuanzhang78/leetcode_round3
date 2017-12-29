package Array;

// 找到最大和第二大的

public class LargestNumberAtLeastTwiceOfOthers {
	 public int dominantIndex(int[] nums) {
	        if (nums == null || nums.length == 0) return -1;
	        int max1 = 0, max2 = 0, idx = -1;
	        for(int i = 0; i < nums.length; i++) {
	            if (max1 < nums[i]) {
	                max2 = max1;
	                max1 = nums[i];
	                idx = i;
	            } else {
	                if (max2 < nums[i]) {
	                    max2 = nums[i];
	                }
	            }
	        }
	        return max1 >= 2*max2? idx : -1;
	    }

}

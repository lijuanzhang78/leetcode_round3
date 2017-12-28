package Array;

public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int start = 0, i = 0;
        for(i = 0; i < nums.length;) {
            start = i; i++;
            while(i < nums.length) {
                if (nums[i] > nums[i-1]) {
                    i++;
                } else {
                    int end = i;
                    res = Math.max(res,end-start);
                    break;
                }
            }   
        }
        return res = Math.max(res,i-start);    
    }
}

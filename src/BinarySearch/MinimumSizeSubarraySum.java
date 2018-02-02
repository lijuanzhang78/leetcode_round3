package BinarySearch;

// two pointer的O（n）解法
// 可以与Maximum size subarray sumII里面的双指针解法一起看
//
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                len = Math.min(len,i - left + 1);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE? 0 : len;
    }

}

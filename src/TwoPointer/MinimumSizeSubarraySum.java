package TwoPointer;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0, j = 0;
        for(int i = 0; i < nums.length;) {
            while(j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                ans = Math.min(ans, j-i);
            }
            sum -= nums[i];
            i++;
        }
        return ans == Integer.MAX_VALUE? 0 : ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		int res = new MinimumSizeSubarraySum().minSubArrayLen(s, nums);
		return;
	}
}

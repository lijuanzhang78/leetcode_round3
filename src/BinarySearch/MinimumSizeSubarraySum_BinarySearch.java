package BinarySearch;

public class MinimumSizeSubarraySum_BinarySearch {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < sum.length; i++) {
            if (sum[i] < s) continue;
            int left = findleftBound(sum,sum[i] - s, 0, i);
            len = Math.min(i-left, len);
        }
        return len == Integer.MAX_VALUE? 0 : len;
    }
    
    int findleftBound(int[] sum, int key, int low, int high) {
        while(low < high) {
            int mid = low + (high - low + 1)/2;
            if (sum[mid] <= key) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;    
    }
    
    public static void main(String[] args) {
    	int[] nums = {2,3,1,2,4,3};
    	int s = 7;
    	int res = new MinimumSizeSubarraySum_BinarySearch().minSubArrayLen(s, nums);
    }
}

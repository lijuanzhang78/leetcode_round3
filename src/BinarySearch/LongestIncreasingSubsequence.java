package BinarySearch;

// Binary search 
// tails[i] stores the smallest tail of all subsequences with length i+1

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            int low = 0, high = size;
            while(low < high) {
                int mid = low + (high - low)/2;
                if (tails[mid] < nums[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            tails[low] = nums[i];
            if (low == size) size++;    
        }
        return size;
    }

}

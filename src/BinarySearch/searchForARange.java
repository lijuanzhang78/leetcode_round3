package BinarySearch;

// 参考topcoder里面binary search的文章
//
public class searchForARange {
	public int[] searchRange(int[] nums, int target) {
        // find the lower bound
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (nums[low] != target) {
            return new int[]{-1,-1};
        }
        int left = low;
        
        // find the higher bound
        low = 0; high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low + 1)/2;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] != target) return new int[]{-1,-1};
        return new int[]{left,low};
    }

}

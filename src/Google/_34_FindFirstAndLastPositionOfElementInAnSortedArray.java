package Google;

public class _34_FindFirstAndLastPositionOfElementInAnSortedArray {
	public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int low = 0, high = nums.length-1;
        // find the left boundary
        while(low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] != target) return new int[]{-1,-1};
        int left = low, right = -1;
        
        // find the right boundary
        low = 0; high = nums.length - 1;
        while(low < high - 1) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                low = mid; 
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }    
        }
        if (nums[high] == target) {
            right = high;
        } else {
            right = low;
        }
        return new int[]{left,right};
    }

}

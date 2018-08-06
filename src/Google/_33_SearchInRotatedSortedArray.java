package Google;

public class _33_SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        while(low < high-1) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] <= nums[high]) { // right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid;
                } else {
                    high = mid;
                }    
            } else {
                if (nums[mid] > target && target >= nums[low]) {
                    high = mid;
                } else {
                    low = mid;
                }
            }   
        }
        if (nums[low] == target) return low;
        if (nums[high] == target) return high;
        return -1;
    }

}

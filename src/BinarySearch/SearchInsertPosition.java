package BinarySearch;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        // equivalent to find the smallest that is larger than the target
        int low = 0, high = nums.length-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        if (nums[low] < target) return low + 1;
        return low;
    }

}

package Google;

public class _153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        while(low < high-1) {
            int mid = low + (high-low)/2;
            //if (nums[mid] == target) return mid;
            if (nums[mid] <= nums[high]) { // right half
               high = mid;
            } else {
               low = mid;
            }   
        }
        if (nums[low] < nums[high]) return nums[low];
        return nums[high];
    }

}

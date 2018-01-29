package BinarySearch;

// 与Kth Smallest Elements In A Sorted Matrix &&
// FindTheDuplicateNumber 很类似
// 都是binary search value，需要查找的数组也是unsorted
//
public class FindKthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        
        // find the minimum of of all pair distance
        int low = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            low = Math.min(low, nums[i]-nums[i-1]);
        }
        int high = nums[nums.length - 1] - nums[0];
        
        while(low < high) {
            int mid = low + (high - low)/2;
            int count = less_equal(nums,mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    int less_equal(int[] nums, int target) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i+1;
            while(j < nums.length && nums[j]-nums[i] <= target) { // 注意必须要check j < nums.length
                j++;
            }
            count += j - i - 1; // 之前写成 count += j - i；
        }
        return count;
    }

}

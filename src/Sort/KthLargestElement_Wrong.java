package Sort;

// it is not recursion at all
//
public class KthLargestElement_Wrong {
	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        
        int index = helper(nums,0,nums.length-1,k);
        return nums[index];
    }
    
    int helper(int[] nums, int low, int high, int k) {
        int index = partition(nums,low,high,k);
        if (index == k) {
            return index;
        } else if (index > k) {
            return partition(nums, low, index-1, k);
        } else {
            return partition(nums, index+1, high, k);
        }
    }
    
    int partition(int[] nums, int low, int high, int k) {
        if (low == high) return low;
        int pivot = nums[high];
        int j = low - 1; // initilize to point to the tail of smaller element
        for(int i = low; i < high; i++) {
            if (nums[i] <= pivot) {
                j++; // j now points to the first element of larger element
                swap(i,j,nums);
            }
        }
        swap(high,j+1,nums); // high is the pivot element
        return j+1; // position of the pivot element
    }
    
    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
    	int[] nums = {3,1,2,4}; // 1,2,3,4
    	int k = 2;
    	int res = new KthLargestElement().findKthLargest(nums, k);
    	return;
    }
}

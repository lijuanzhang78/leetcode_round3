package Sort;

// 这种先处理当前case再舍弃一块递归的方式非常有BST的风格
//
public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        
        int index = partition(nums,0,nums.length-1,k);
        return nums[index];
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
        int index = j+1; // position of the pivot element
        
        if (index == k) {
            return index;
        } else if (index > k) {
            return partition(nums, low, index-1, k); // 直接return说明只有可能有这条分支
        } else {
            return partition(nums, index+1, high, k);
        }
    }
    
    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	

}

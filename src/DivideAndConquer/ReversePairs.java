package DivideAndConquer;

// Merge sort
// 好像还要其他解法：BST，BIT
//
public class ReversePairs {
	public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        return mergeSort(nums,0,nums.length - 1);
    }
    
    int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int mid = s + (e-s)/2;
        int count = mergeSort(nums,s,mid) + mergeSort(nums,mid+1,e);
        for(int i = s, j = mid + 1; i <= mid; i++) {
            while(j <= e && nums[i]/2.0 > nums[j]) j++;
            count += j-(mid+1);
        }
        Arrays.sort(nums,s,e+1);
        return count;
    }

}

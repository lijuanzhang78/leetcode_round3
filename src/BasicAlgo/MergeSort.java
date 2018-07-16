package BasicAlgo;

public class MergeSort {
	public void mergeSort(int[] nums) {
		mergeSort(nums,0,nums.length-1);
	}
	
	void mergeSort(int[] nums, int low, int high) {
		if (low == high) {
			return;
		}
		// divide the problem into 2 subproblems
		int mid = low + (high-low)/2;
		mergeSort(nums,low,mid);
		mergeSort(nums,mid+1,high);
		merge(nums,low,mid,high);
	}
	
	// copy the numbers to L & R
	void merge(int[] nums, int low, int mid, int high) {
		int n1 = mid-low+1;
		int n2 = high-mid;
		int[] L = new int[n1], R = new int[n2];
		for(int i = 0; i < n1; i++) {
			L[i] = nums[low+i];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = nums[mid+1+j];
		}
		int i = 0, j = 0, k = low;
		while(i < n1 && j < n2) {
			nums[k++] = L[i] <= R[j]? L[i++] : R[j++];
		}
		while(i < n1) {
			nums[k++] = L[i++];
		}
		while(j < n2) {
			nums[k++] = R[j++];
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,5,3,7,4,8,1};
		new MergeSort().mergeSort(nums);
		return;	
	}
}

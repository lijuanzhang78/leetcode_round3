package Google;

public class _280_WiggleSort {
	public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for(int i = 0; i < nums.length; i++) {
            if (i+1 == nums.length) break;
            if (i%2 == 0) {
                if (nums[i+1] < nums[i]) {
                    swap(i+1,i,nums);
                }
            } else {
                if (nums[i+1] > nums[i]) {
                    swap(i+1,i,nums);
                }
            }
        }
        return;
    }
    
    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

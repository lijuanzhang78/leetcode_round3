package Amazon;

public class _238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        int right = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}

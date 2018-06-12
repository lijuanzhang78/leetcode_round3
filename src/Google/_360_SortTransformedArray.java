package Google;

public class _360_SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) return new int[0];
        int low = 0, high = nums.length-1;
        int[] res = new int[nums.length];
        if (a >= 0) {
            sort1(res,a,b,c,nums);
        } else {
            sort2(res,a,b,c,nums);
        }
        return res;
    }
    
    void sort1(int[] res, int a, int b, int c, int[] nums) {
        int low = 0, high = nums.length-1, index = nums.length-1;
        while(low <= high) {
            int res1 = a*nums[low]*nums[low] + b*nums[low] + c;
            int res2 = a*nums[high]*nums[high] + b*nums[high] + c;
            if (res1 >= res2) {
                res[index--] = res1;
                low++;
            } else {
                res[index--] = res2;
                high--;
            }
        }
    }
    void sort2(int[] res, int a, int b, int c, int[] nums) {
        int low = 0, high = nums.length-1, index = 0;
        while(low <= high) {
            int res1 = a*nums[low]*nums[low] + b*nums[low] + c;
            int res2 = a*nums[high]*nums[high] + b*nums[high] + c;
            if (res1 <= res2) {
                res[index++] = res1;
                low++;
            } else {
                res[index++] = res2;
                high--;
            }
        }
    }

}

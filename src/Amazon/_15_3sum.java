package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3sum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int low = i+1, high = nums.length-1;
            while(low < high) {
                if (nums[low]+nums[high] == target) {
                    //int[] index = new int[]{i,low,high};
                    //res.add(Arrays.asList(index));
                    List<Integer> list = new ArrayList<>();
                    list.add(i);list.add(low);list.add(high);
                    res.add(list);
                    while(low < high && nums[low+1] == nums[low]) low++;
                    low++;
                    while(low < high && nums[high-1] == nums[high]) high--;
                    high--;
                } else if (nums[low]+nums[high] >  target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {}
	}
	
	

}

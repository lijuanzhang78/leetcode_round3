package DynamicProgramming;

public class HouseRobberII {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums,0,nums.length-2), rob(nums,1,nums.length-1));
    }
    
    int rob(int[] nums, int start, int end) {
        int rob = 0, norob = 0;
        for(int i = start; i <= end; i++) {
            int temp = rob;
            rob = norob + nums[i];
            norob = Math.max(temp,norob);
        }
        return Math.max(rob,norob);
    }

}

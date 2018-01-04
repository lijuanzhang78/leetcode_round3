package DynamicProgramming;

public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int norob = 0; // max value if not rob current house;
        int rob = 0; // max value if rob current house;
        
        for(int i = 0; i < nums.length; i++) {
            int currrob = norob + nums[i];
            norob = Math.max(norob,rob);
            rob = currrob;
        }
        return Math.max(norob,rob);
    }
}

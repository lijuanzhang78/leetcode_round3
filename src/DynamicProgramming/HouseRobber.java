package DynamicProgramming;

// 对于nums【i】，可以rob，也可以不rob
// 如果rob，rob = norob(上一个) + numsp[i]
// 如果不rob， norob = Math.max(norob（上一个）, rob（上一个）)
//
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

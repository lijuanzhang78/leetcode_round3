package TwoPointer;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int currLen = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxLen = Math.max(maxLen,currLen);
                currLen = 0;
            } else {
                currLen++;
            }
        }
        return Math.max(maxLen,currLen);
    }
}

package TwoPointer;

// 算法强化班-3
// 从两边往中间灌水
//
public class TrappingRainWater {
	public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftHeight = height[0], rightHeight = height[height.length-1];
        int res = 0;
        while(left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (height[left] < leftHeight) {
                    res += leftHeight - height[left];
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if (height[right] < rightHeight) {
                    res += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
            }
        } 
        return res;
    }

}

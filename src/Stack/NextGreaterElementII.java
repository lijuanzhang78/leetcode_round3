package Stack;

public class NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,Integer.MIN_VALUE);
        int n = nums.length;
        for(int i = 0; i < 2*n - 1; i++) {
            if (stack.size() == 0 || nums[stack.peek()] >= nums[i%n]) {
                stack.push(i%n);
            } else { // stack.size() > 0 && stack.peek() <= nums[i]
                while(stack.size() > 0 && nums[stack.peek()] < nums[i%n]) {
                    res[stack.pop()] = nums[i%n];
                }
                stack.push(i%n);
            }
        }
        while(stack.size() > 0) {
            int index = stack.pop();
            // need to check res[index] == Integer.MIN_VALUE
            if(res[index] == Integer.MIN_VALUE) res[index] = -1;
        }
        return res;
    }

}

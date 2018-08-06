package Google;

public class _503_NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i = 0; i < 2*nums.length; i++) {
            int j = i%nums.length;
            while(stack.size() > 0 && nums[stack.peek()] < nums[j]) {
                int top = stack.peek();
                res[top] = nums[j];
                stack.pop();
            }
            stack.push(j);
        }
        return res;
    }

}

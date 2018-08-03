package Google;

public class _496_NextGreaterElement {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        int n = nums1.length;
        int[] res = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < nums2.length; i++) {
            while(stack.size() > 0 && nums2[i] > stack.peek()) {
                int top = stack.peek();
                map.put(top,nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }

}

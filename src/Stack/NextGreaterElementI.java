package Stack;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums2) {
            if (stack.size() == 0 || stack.peek() > num) {
                stack.push(num);
            } else { // stack.size() > 0 && stack.peek() <= num
                while(stack.size() > 0 && stack.peek() < num) {
                    map.put(stack.pop(),num);
                }
                stack.push(num);   
            }
        }
        
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = map.get(nums1[i]);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

}

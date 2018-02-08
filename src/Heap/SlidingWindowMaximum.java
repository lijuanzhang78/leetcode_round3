package Heap;


public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() == i-k) {
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            q.offerLast(i);
            if (i >= k-1) res[i-k+1] = nums[q.peek()];
        }
        return res;
    }

}

package Google;

public class _239_SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<Integer>();
        // put the first window in the queue and keep it in decreasing order
        for(int i = 0; i < k; i++) {
            while(q.size() > 0 && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        int index = 0;
        res[index++] = nums[q.peekFirst()];
        
        for(int i = k; i < nums.length; i++) {
            if (nums[i-k] == nums[q.peekFirst()]) q.pollFirst();
            while(q.size() > 0 && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            res[index++] = nums[q.peekFirst()];
        }
        return res;
    }

}

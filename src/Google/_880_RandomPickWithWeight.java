package Google;

public class _880_RandomPickWithWeight {
	class Solution {
	    int[] presum;
	    int max;
	    Random rand = new Random();
	    

	    public Solution(int[] w) {
	        presum = new int[w.length];
	        presum[0] = w[0];
	        for(int i = 1; i < w.length; i++) {
	            presum[i] = presum[i-1] + w[i];
	        }
	        max = presum[presum.length-1];
	    }
	    
	    public int pickIndex() {
	        int idx = rand.nextInt(max) + 1;
	        int low = 0, high = presum.length-1;
	        while(low < high) {
	            int mid = low + (high-low)/2;
	            if (presum[mid] < idx) {
	                low = mid + 1;
	            } else {
	                high = mid;
	            }
	        }
	        return low;
	    }
	}

}

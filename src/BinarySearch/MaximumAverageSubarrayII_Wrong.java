package BinarySearch;

public class MaximumAverageSubarrayII_Wrong {
	public double findMaxAverage(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        double low = (double)min;
        double high = (double)max;
        
        while(high - low > 0.000001) {
            double mid = low + (high-low)/2.0;
            if (check_larger(mid,nums,k)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    boolean check_larger(double mid, int[] nums, int k) {
        double diff[] = new double[nums.length];
        for(int i = 0; i < nums.length; i++) {
            diff[i] = nums[i] - mid;  
        }
        // check if there is any average of subarray larger than mid
        // equivalent to find if diff[i] + diff[i+1] + ... + diff[j] > 0
        // use two pointer, get the largest sum of subarray ending at i
        //
        int sum = 0, leftsum = 0;
        for(int i = 0; i < k; i++) {
            sum += diff[i];
        }
        // loop invariant: sum is not checked yet
        //
        for(int i = k; i < nums.length; i++) {
            if (sum >= 0) return true;
            sum += diff[i];
            leftsum += diff[i-k];
            if (leftsum < 0) {
                sum -= leftsum;
                leftsum = 0;
            }
        }
        return sum >= 0;
    }

}

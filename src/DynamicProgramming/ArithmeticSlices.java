package DynamicProgramming;

public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        dp[0] = 0; dp[1] = 0; 
        int diff = A[1] - A[0];
        int count = 0;
        for(int i = 2; i < A.length; i++) {
            if (A[i]-A[i-1] == diff) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 0;
            }
            diff = A[i] - A[i-1]; 
            count += dp[i];
        }
        return count;
    }

}

package DFS;

public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n+1];
        dp[1] = 10;
        int base = 9;
        for(int i = 2, num = 9; i <= Math.min(10,n); i++,num--) {
            base *= num;
            dp[i] = dp[i-1] + base;
        }
        return n <= 10? dp[n] : dp[10];   
    }

}

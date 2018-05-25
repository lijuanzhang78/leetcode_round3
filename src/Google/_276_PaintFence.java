package Google;

public class _276_PaintFence {
	public int numWays(int n, int k) {
        if (n <= 0) return 0;
        if (k <= 0) return 0;
        int[] same = new int[n];
        int[] diff = new int[n];
        same[0] = 0;
        diff[0] = k;
        for(int i = 1; i < n; i++) {
            same[i] = diff[i-1];
            diff[i] = (same[i-1]+diff[i-1])*(k-1);
        }
        return same[n-1]+diff[n-1];
    }

}

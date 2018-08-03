package Google;

public class _813_LargetSumOfAverages_bottomup {
	public double largestSumOfAverages(int[] A, int K) {
        if (K == 0 || A.length == 0) {
            return 0;
        }
        int l = A.length;
        double[][] f = new double[l][K + 1];
        double[] s = new double[l + 1];
        for (int i = 1; i <= l; i++) {
            s[i] = s[i - 1] + A[i - 1];
            f[i - 1][1] =  s[i] / i;
        }
        for (int j = 2; j <= K; j++) {
            for (int i = 0; i < l; i++) {
                if (i+1 < j) continue; // not valid 
                double max = Double.MIN_VALUE;
                for (int p = 0; p < i; p++) {
                    if (p+1 < j-1) continue;
                    double sum = f[p][j - 1] + (s[i + 1] - s[p + 1]) / (i - p);
                    max = Double.max(sum, max);
                }
                f[i][j] = max;
            }
        }
        return f[l - 1][K];
    }

}

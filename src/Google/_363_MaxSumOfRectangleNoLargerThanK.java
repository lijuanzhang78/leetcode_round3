package Google;

public class _363_MaxSumOfRectangleNoLargerThanK {
	public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int left = 0; left < n; left++) {
            int[] sum = new int[m]; // allocate new 'sum' array for a fixated left
            for(int right = left; right < n; right++) {
                for(int i = 0; i < m; i++) {
                    sum[i] += matrix[i][right];
                }
                TreeSet<Integer> treeset = new TreeSet<>();
                treeset.add(0);
                int cumulative = 0;
                for(int i = 0; i < m; i++) {
                    cumulative += sum[i];
                    Integer candidate = treeset.ceiling(cumulative-k); // 大于这个数的最小数
                    if (candidate != null) {
                        max = Math.max(cumulative-candidate,max);
                    } 
                    treeset.add(cumulative);
                }
            }
        }
        return max;
    }

}

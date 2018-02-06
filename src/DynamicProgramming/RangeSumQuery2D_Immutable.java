package DynamicProgramming;

public class RangeSumQuery2D_Immutable {
	int[][] sum;
    int m, n;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum[i][j] += matrix[i][j];
                if (i > 0) sum[i][j] += sum[i-1][j];
                if (j > 0) sum[i][j] += sum[i][j-1];
                if (i > 0 && j > 0) sum[i][j] -= sum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        res += sum[row2][col2];
        if (row1 > 0) res -= sum[row1-1][col2];
        if (col1 > 0) res -= sum[row2][col1-1];
        if (row1 > 0 && col1 > 0) res += sum[row1-1][col1-1];
        return res;
    }
}

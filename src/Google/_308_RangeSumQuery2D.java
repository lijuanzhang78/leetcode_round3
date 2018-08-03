package Google;

public class _308_RangeSumQuery2D {
	class NumMatrix {
	    int[][] colSum;
	    int[][] matrix;

	    public NumMatrix(int[][] matrix) {
	        this.matrix = matrix;
	        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
	        colSum = new int[matrix.length][matrix[0].length];
	        for(int i = 1; i < matrix.length; i++) {
	            for(int j = 0; j < matrix[0].length; j++) {
	                colSum[i][j] = colSum[i-1][j] + matrix[i][j];
	            }
	        }
	    }
	    
	    public void update(int row, int col, int val) {
	        for(int i = row; i < matrix.length; i++) {
	            colSum[i][col] += val - matrix[row][col];
	        }
	        matrix[row][col] = val;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int res = 0;
	        for(int i = 0; i <= col2-col1; i++) {
	            res += colSum[row2][i+col1] - colSum[row1][i+col1] + matrix[row1][i+col1];    
	        }
	        return res;
	    }
	}

}

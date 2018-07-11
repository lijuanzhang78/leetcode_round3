package Google;

public class _766_ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return true;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m-1; i++) {
            for(int j = 0; j < n-1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1]) return false;
            }
        }
        return true;
    }

}

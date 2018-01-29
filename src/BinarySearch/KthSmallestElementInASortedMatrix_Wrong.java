package BinarySearch;

public class KthSmallestElementInASortedMatrix_Wrong {
	public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m-1][n-1];
        while(low < high) {
            int mid = low + (high - low + 1)/2;
            int count = smaller_equal(matrix,mid);
            if (count > k) { // 错误
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }
    
    int smaller_equal(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int j = matrix[0].length - 1; // from the top right element to take advantage of the sorted matrix
        int count = 0;
        for(int i = 0; i < m; i++) {
            while(j >= 0 && matrix[i][j] > target) {
                j--;
            }
            count += j+1;
        }
        return count;
    }

}

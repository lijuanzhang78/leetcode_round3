package Google;

public class _832_flippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) return new int[0][0];
        int mid = (A[0].length+1)/2; // round up, 错误
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < mid; j++) {
                int temp = A[i][j]^1;
                A[i][j] = A[i][A[0].length-1-j]^1;
                A[i][A[0].length-1-j] = temp;
            }
        }
        return A;
    }

}

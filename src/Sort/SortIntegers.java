package Sort;

public class SortIntegers {
	public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) return;
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if (A[i] < A[j]) {
                    int temp = A[i];
                    for(int k = i-1; k >= j; k--) {
                        A[k+1] = A[k];
                    }
                    A[j] = temp;
                }
                break;
            }
        }
        return;
    }
	
	public static void main(String[] args) {
		int[] A = {5,3,4,2};
		new SortIntegers().sortIntegers(A);
		return;
	}

}

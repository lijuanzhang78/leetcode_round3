package Google;

public class _162_FindPeakElement {
	public int findPeakElement(int[] A) {
        int low = 0, high = A.length - 1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if (A[mid+1] < A[mid]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
        
    }

}

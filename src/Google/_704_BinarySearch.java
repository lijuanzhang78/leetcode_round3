package Google;

public class _704_BinarySearch {
	public int search(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        int low = 0, high = A.length-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if (A[mid] == target) return mid;
            if (A[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        if (A[low] == target) return low;
        return -1;
    }

}

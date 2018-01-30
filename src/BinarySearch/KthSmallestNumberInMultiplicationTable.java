package BinarySearch;

public class KthSmallestNumberInMultiplicationTable {
	public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m*n;
        while(low < high) {
            int mid = low + (high - low)/2;
            if (count_less_equal(m,n,mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    int count_less_equal(int m, int n, int key) {
        int count = 0;
        for(int i = 1; i <= m; i++) {
            int colNum = key/i;
            count += Math.min(colNum,n);   
        }
        return count;
    }

}

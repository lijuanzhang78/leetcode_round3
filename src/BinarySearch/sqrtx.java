package BinarySearch;

public class sqrtx {
	public int mySqrt(int x) {
        if (x == 0) return 0;
        long low = 1, high = x;
        while(low < high) {
            long mid = low + (high - low + 1)/2;
            if (mid*mid <= (long)x) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int)low;
    }    
}


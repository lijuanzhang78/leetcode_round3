package BinarySearch;

// 参考topcoder里面binary search的文章
// the answer should exist between [1,n]
//
public class ArrangeCoins {
	public int arrangeCoins(int n) {
        if (n == 0) return 0;
        long low = 1, high = n;
        while(low < high) {
            long mid = low + (high-low+1)/2;
            if (mid*(mid+1) > 2*(long)n) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return (int)low;
    }

}

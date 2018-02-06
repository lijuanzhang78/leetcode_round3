package Heap;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int count = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        while(count < n) {
            int next = Math.min(Math.min(res[p2]*2, res[p3]*3), res[p5]*5);
            if (res[p2]*2 == next) p2++;
            if (res[p3]*3 == next) p3++;
            if (res[p5]*5 == next) p5++;
            res[count] = next;
            count++;    
        }
        return res[count-1];
    }

}

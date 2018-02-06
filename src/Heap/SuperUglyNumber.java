package Heap;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0) return 0;
        int k = primes.length; // k sequences to choose next uply number from
        int[] idx = new int[k];
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int count = 1;
        
        while(count < n) {
            // find the next minimal ugly number of groups of sequences
            int next = Integer.MAX_VALUE;
            for(int i = 0; i < k; i++) {
                next = Math.min(next,uglyNum[idx[i]]*primes[i]);
            }
            for(int i = 0; i < k; i++) {
                if (next == uglyNum[idx[i]]*primes[i]) idx[i]++;
            }
            uglyNum[count] = next;
            count++;
            
        }
        return uglyNum[n-1];
    }

}

package DynamicProgramming;

public class CoinPath {
	public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0 || A[0] < 0) return res;
        
        int[] next = new int[A.length];
        long[] memo = new long[A.length];
        Arrays.fill(next,-1);
        jump(A,B,next,0,memo);
        // 这一段特别容易写错！！////////////////////
        int i = 0;
        for(i = 0; i < A.length && next[i] > 0;) {
            res.add(i+1);
            i = next[i];
        }
        if (i == A.length - 1 && A[i] >= 0) {
            res.add(i+1);
        }
        ///////////////////////////////////////
        
        return res;
    }
    
    long jump(int[] A, int B, int[] next, int pos, long[] memo) { // returns the minimum cost to the end from pos
        if (pos == A.length - 1) {
            return A[pos] >= 0? A[pos] : -1;    
        }
        
        if (A[pos] == -1) {
            next[pos] = -1;
            return -1;
        }
        
        if (memo[pos] > 0) return (int)memo[pos];
        
        long minCost = Integer.MAX_VALUE;
        for(int i = pos+1; i <= pos+B && i < A.length; i++) {
            long cost = jump(A,B,next,i,memo);
            if (cost >= 0) {
                if (cost < minCost) {
                    minCost = cost;
                    next[pos] = i;
                }
            }
        }
        if (minCost == Integer.MAX_VALUE) {
            next[pos] = -1;
            memo[pos] = minCost;
            return minCost;
        } else {
            memo[pos] = minCost + A[pos];
            return memo[pos];
        }
    }

}

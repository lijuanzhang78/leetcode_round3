package Google;

import java.util.Arrays;

public class _787_CheapestFlightsWithinKStops {
	int min;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length == 0) return 0;
        min = Integer.MAX_VALUE;
        dfs(src,dst,K+1,flights,0);
        return min == Integer.MAX_VALUE? -1 : min;
    } 
    
    void dfs(int src, int dest, int K, int[][] flights, int fee) {
        if (K < 0) return;
        if (fee > min) return;
        if (src == dest) {
            min = Math.min(fee,min);
            return;
        }
        for(int[] f : flights) {
            if (f[0] == src) {
                dfs(f[1],dest,K-1,flights,fee + f[2]);
            }
        }
    }
    
    //public static void main(String[] args) {
    //	int n = 4, src = 0, dst = 3, K = 1;
    //	int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
    //	int res = new _787_CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, K);
    //	return;
    	
    //}
    
    public static void main(String[] args) {
    	int n = 3, src = 0, dst = 2, K = 1;
    	int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
    	int res = new _787_CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, K);
    	return;
    	
    }

}

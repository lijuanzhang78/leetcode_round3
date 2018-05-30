package Google;

public class _774_Minimize_Max_Distance_to_Gas_Station {
	public double minmaxGasDist(int[] stations, int K) {
        if (stations == null || stations.length == 0) return 0.0;
        double low = 0, high = 1.0e8;
        while(high-low > 1.0e-6) {
            double mid = low + (high-low)/2.0;
            if (possible(mid,stations) <= K) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }
    
    int possible(double mid, int[] stations) {
        int count = 0;
        for(int i = 0; i < stations.length - 1; i++) {
            count += (int)((stations[i+1]-stations[i])/mid);
        }
        return count;
    }

}

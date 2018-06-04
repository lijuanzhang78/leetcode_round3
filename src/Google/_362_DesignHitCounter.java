package Google;

public class _362_DesignHitCounter {
	int[] counts;
    int[] times;

    /** Initialize your data structure here. */
    public HitCounter() {
        counts = new int[300];
        times = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int pos = timestamp % 300;
        if (times[pos] != timestamp) {
            counts[pos] = 1;
            times[pos] = timestamp;
        } else {
            counts[pos]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int i = 0; i < 300; i++) {
            if (times[i] <= timestamp && times[i] > timestamp-300) {
                count += counts[i];
            }
        }
        return count;
    }

}

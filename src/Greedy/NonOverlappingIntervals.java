package Greedy;

// sort intervals by end.
// start time does not matter.
//
public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b)->(a.end-b.end));
        Interval prev = intervals[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < prev.end) {
                count++;
            } else {
                prev = intervals[i];
            }   
        }
        return count;
    }

}

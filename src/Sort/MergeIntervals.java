package Sort;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        
        Collections.sort(intervals, (a,b)->(a.start - b.start)); // Collections, not Collection
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= prev.end) {
                prev.end = Math.max(prev.end, intervals.get(i).end);
            } else {
                res.add(prev);
                prev = intervals.get(i);
            }    
        }
        res.add(prev); // 注意别忘了最后一个element
        return res;
    }

}

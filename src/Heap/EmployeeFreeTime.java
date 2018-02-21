package Heap;

public class EmployeeFreeTime {
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.size() == 0) return new ArrayList<Interval>();
        List<Interval> timeline = new ArrayList<>();
        for(List<Interval> each : schedule) {
            for(Interval interval : each) {
                timeline.add(interval);
            }
        }
        Collections.sort(timeline, (a,b)->(a.start == b.start ? a.end - b.end : a.start - b.start));
        List<Interval> res = new ArrayList<>();
        Interval prev = timeline.get(0);
        for(int i = 0; i < timeline.size(); i++) {
            Interval curr = timeline.get(i);
            if (curr.start <= prev.end) {
                curr.end = Math.max(prev.end,curr.end);
            } else {
                res.add(new Interval(prev.end,curr.start));
            }
            prev = curr;
        }
        return res;
    }

}

package BinarySearch;

public class FindRightInterval {
	public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0];
        // no same start point
        int[] res = new int[intervals.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);   
        }
        Arrays.sort(intervals, (a,b)->(a.start - b.start));
        for(int i = 0; i < intervals.length; i++) {
            int key = intervals[i].end; 
            // binary search to find the smallest start bigger than key
            int index = binarySearch(key,intervals,i+1,intervals.length-1,map);
            res[map.get(intervals[i].start)] = index;
        }
        return res;
    }
    
    int binarySearch(int key, Interval[] intervals, int low, int high, Map<Integer,Integer> map) {
        if (low > intervals.length - 1) return -1; // 注意这里不能是low >= intervals.length - 1， 要不倒数第二个元素会出错
        while(low < high) {
            int mid = low + (high - low)/2;
            if (intervals[mid].start < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (intervals[low].start >= key) {
            return map.get(intervals[low].start);
        } else {
            return -1;
        }   
    }

}

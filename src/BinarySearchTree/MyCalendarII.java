package BinarySearchTree;

public class MyCalendarII {
	List<int[]> calendars;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        calendars = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for(int[] overlap : overlaps) {
            if (start < overlap[1] && overlap[0] < end) return false;
        }
        
        for(int[] calendar : calendars) {
            if (start < calendar[1] && calendar[0] < end) {
                overlaps.add(new int[]{Math.max(start,calendar[0]), Math.min(end, calendar[1])});
            }
        }
        calendars.add(new int[]{start,end});
        return true;
    }

}

package BinarySearchTree;

public class MyCalendarI {
TreeMap<Integer, Integer> map;
    
    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((prev == null || start >= map.get(prev)) && (next == null || end <= next)) {
            map.put(start,end);
            return true;
        }
        return false;
    }

}

package Heap;

// 首先按照start time sort所有的区间
// 使用heap， based on end time
//
public class MeetingRoomII {
	public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // sort all interals based on start time
        Arrays.sort(intervals, (a,b)->(a.start-b.start));
        Queue<Interval> q = new PriorityQueue<>((a,b)->(a.end - b.end));
        
        q.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            if (q.peek().end <= intervals[i].start) {
                q.poll();
            }
            q.offer(intervals[i]);
        }
        return q.size();
    }

}

// If you look at these events in a time line one after another (like stream data), then this solution is a greedy solution.

// The heap stores all conflicting events, which must be resolved by independent rooms. The heap’s head is the event that has earliest end/finish time. All other events collide with each other mutually in the heap.

// When a new event comes (this is the reason that we need to sort by event.start), we greedily choose the event A that finished the earliest (this is the reason that we use minheap on end time). If the new event does not collide with A, then the new event can re-use A’s room, or simply extend A’s room to the new event’s end time.

// If the new event collides with A, then it must collide with all events in the heap. So a new room must be created.

// The reason for correctness is the invariant: heap size is always the minimum number of rooms we need so far. If the new event collides with everyone, then a new room must be created; if the new event does not collide with someone, then it must not collide with the earliest finish one, so greedily choose that one and re-use that room. So the invariant is maintained.

// I wish I can have this thinking angle :)

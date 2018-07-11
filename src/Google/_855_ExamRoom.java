package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _855_ExamRoom {
	//class ExamRoom {
	    Queue<Gap> pq;
	    Map<Integer,Gap> starts;
	    Map<Integer,Gap> ends;
	    int max;
	    
	    class Gap{
	        int start, end;
	        int length;
	        Gap(int start, int end, int N) {
	            this.start = start;
	            this.end = end;
	            if (start == 0) {
	                length = end;
	            } else if (end == N) {
	                length = N-start;
	            } else {
	                length = (end-start)/2;
	            }   
	        }
	    }
	    
	    void puttoMap(Gap gap) {
	        starts.put(gap.start,gap);
	        ends.put(gap.end,gap);
	    }
	    
	    void removeGap(Gap gap) {
	        starts.remove(gap.start);
	        ends.remove(gap.end);
	    }
	    
	    public _855_ExamRoom(int N) {
	        pq = new PriorityQueue<Gap>((a,b)->(b.length == a.length? a.start-b.start : b.length - a.length));
	        starts = new HashMap<Integer,Gap>();
	        ends = new HashMap<Integer,Gap>();
	        max = N-1;
	        Gap gap = new Gap(0,max,max);
	        pq.offer(gap);
	        puttoMap(gap);
	    }
	    
	    public int seat() {
	        int pos = -1;
	        if (pq.size() > 0) {
	          Gap gap = pq.poll();
	          if (gap.start == 0) {
	              if (gap.end >= 1) {
	                Gap newGap = new Gap(1,gap.end,max); 
	                puttoMap(newGap);
	                pq.offer(newGap);
	              }
	              pos = 0;
	          } else if (gap.end == max) {
	              if (max-1 >= gap.start) {
	                Gap newGap = new Gap(gap.start,max-1,max);
	                puttoMap(newGap);
	                pq.offer(newGap);
	              }
	              pos = max;
	          } else {
	              pos = gap.start + gap.length;
	              if (gap.start <= pos-1) {
	                  Gap newGap = new Gap(gap.start,pos-1,max);
	                  puttoMap(newGap);
	                  pq.offer(newGap);
	              } 
	              if (pos+1 <= gap.end) {
	                  Gap newGap = new Gap(pos+1,gap.end,max);
	                  puttoMap(newGap);
	                  pq.offer(newGap);
	              }
	          }
	          return pos;
	        } else {
	            return -1;
	        }    
	    }
	    
	    public void leave(int p) {
	        Gap prev = null, next = null;
	        if (ends.containsKey(p-1)) {
	            prev = ends.get(p-1);
	        }
	        if (starts.containsKey(p+1)) {
	            next = starts.get(p+1);
	        }
	        if (prev != null && next != null) {
	            pq.remove(prev);pq.remove(next);
	            removeGap(prev);removeGap(next);
	            Gap newGap = new Gap(prev.start,next.end,max);
	            puttoMap(newGap);
	            pq.offer(newGap);
	        } else if (prev != null) {
	            pq.remove(prev);
	            removeGap(prev);
	            Gap newGap = new Gap(prev.start,p,max);
	            puttoMap(newGap);
	            pq.offer(newGap);
	        } else if (next != null) {
	            pq.remove(next);
	            removeGap(next);
	            Gap newGap = new Gap(p,next.end,max);
	            puttoMap(newGap);
	            pq.offer(newGap);
	        } else {
	            Gap newGap = new Gap(p,p,max);
	            puttoMap(newGap);
	            pq.offer(newGap);
	        }
	    }
	    
	    public static void main(String[] args) {
			_855_ExamRoom room = new _855_ExamRoom(4);
			int res0 = room.seat();
			int res3 = room.seat();
			int res1 = room.seat();
			int res2 = room.seat();
			room.leave(1);
			room.leave(3);
			int res = room.seat();
			return;
		}
	}	
//}

package Google_Others;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BenchSeating {
	class gap {
		int start; // starting seat index
		int end; // ending seat index
		int size;
		gap(int start, int end) {
			this.start = start;
			this.end = end;
			this.size = end-start+1;
		}
	}
	// bench contains a list of seats: 0 means empty and 1 means occupied
	//
	List<Integer> getFurthestSeating(int[] bench, int n) {
		if (n <= 0) return new ArrayList<Integer>();
		// create max heap
		Queue<gap> pq = new PriorityQueue<>((a,b)->(b.size-a.size));
		int start = -1;
		for(int i = 0; i < bench.length; i++) {
			if (bench[i] == 1) {
				if (start != -1) {
					// create gap
					pq.offer(new gap(start,i-1));
					start = -1;
				}
			} else {
				if (start == -1) {
					start = i;
				}
			}	
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if (pq.size() == 0) break;
			gap maxgap = pq.poll();
			int st = maxgap.start, end = maxgap.end;
			int mid = st +(end-st)/2;
			res.add(mid);
			if (mid-1 >= st) {
				pq.offer(new gap(st,mid-1));
			}
			if (mid+1 <= end) {
				pq.offer(new gap(mid+1,end));
			}	
		}
		return res;	
	}
}

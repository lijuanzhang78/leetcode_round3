package Google;

public class _295_FindMedianFromDataStream {
	Queue<Integer> maxHeap;
    Queue<Integer> minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        // size of maxHeap >= size of minHeap
        maxHeap = new PriorityQueue<Integer>((a,b)->(b-a));
        minHeap = new PriorityQueue<Integer>(); // default;
    }
    
    public void addNum(int num) {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(num);
            if (maxHeap.size() > 0 && minHeap.size() > 0 && minHeap.peek() < maxHeap.peek()) {
                int small = minHeap.poll();
                maxHeap.offer(small);
                minHeap.offer(maxHeap.poll());
            } 
        } else {
            maxHeap.offer(num);
            if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                int large = maxHeap.poll();
                minHeap.offer(large);
                maxHeap.offer(minHeap.poll());
            }
        }    
    }
    
    public double findMedian() {
        int count = maxHeap.size() + minHeap.size();
        if (count % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else {
            return maxHeap.peek()*1.0;
        }    
    }

}

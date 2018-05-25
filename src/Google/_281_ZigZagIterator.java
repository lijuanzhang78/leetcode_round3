package Google;

public class _281_ZigZagIterator {
	Queue<Iterator<Integer>> q;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<Iterator<Integer>>();
        if (v1.iterator().hasNext()) q.offer(v1.iterator());
        if (v2.iterator().hasNext()) q.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> curr = q.poll();
        int next = curr.next();
        if (curr.hasNext()) q.offer(curr);
        return next;
    }

    public boolean hasNext() {
        return q.size() > 0;
    }

}

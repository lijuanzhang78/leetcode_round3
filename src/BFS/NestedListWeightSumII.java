package BFS;

//
public class NestedListWeightSumII {
	public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for(NestedInteger ni : nestedList) {
            q.offer(ni);
        }
        
        int sum = 0, prev = 0;
        while(q.size() > 0) {
            int size = q.size();
            int levelSum = 0;
            for(int i = 0; i < size; i++) {
                NestedInteger ni = q.poll();
                if (ni.isInteger()) {
                    levelSum += ni.getInteger();
                } else {
                    q.addAll(ni.getList());
                }    
            }
            prev += levelSum;
            sum += prev;
        }
        return sum;
    }
}

package Google;

public class _341_FlattenNestedListIterator {
	public class NestedIterator implements Iterator<Integer> {
	    LinkedList<Iterator<NestedInteger>> stack;
	    List<NestedInteger> nestedList;
	    Integer nextInt;
	    
	    public NestedIterator(List<NestedInteger> nestedList) {
	        stack = new LinkedList<Iterator<NestedInteger>>();
	        this.nestedList = nestedList;
	        nextInt = null;
	        stack.push(nestedList.iterator());
	    }

	    @Override
	    public Integer next() {
	        return nextInt;
	    }

	    @Override
	    public boolean hasNext() {
	        while(stack.size() > 0) {
	            Iterator<NestedInteger> top = stack.peek();
	            if (top.hasNext()) {
	                NestedInteger next = top.next();
	                if (next.isInteger()) {
	                    nextInt = next.getInteger();
	                    return true;
	                } else {
	                    stack.push(next.getList().iterator());
	                }
	            } else {
	                stack.pop();
	            }    
	        }
	        return false;
	    }
	}

}

package Stack;

public class FlattenNestedListIterator {
	LinkedList<Iterator<NestedInteger>> stack = new LinkedList<>();
    NestedInteger nextInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList == null) return;
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(stack.size() > 0) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger next = stack.peek().next();
                if (next.isInteger()) {
                    nextInt = next;
                    return true;
                } else {
                    stack.push(next.getList().iterator());
                }
            }    
        }
        return false;
    }

}

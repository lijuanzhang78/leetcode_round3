package Tree;

public class VerifyPreorderSequenceInBST {
	public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        LinkedList<Integer> stack = new LinkedList<>();
        
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < preorder.length; i++) {
            if (stack.size() == 0) {
                stack.push(preorder[i]);
            } else {
                if (low != Integer.MAX_VALUE && preorder[i] < low) return false;
                if (preorder[i] <= stack.peek()) {
                    stack.push(preorder[i]);
                } else {
                    while(stack.size() > 0 && preorder[i] > stack.peek()) {
                        low = stack.pop();
                    }
                    stack.push(preorder[i]);    
                }    
            }
        }
        return true;
    }

}

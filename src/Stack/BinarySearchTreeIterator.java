package Stack;

public class BinarySearchTreeIterator {
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    public BSTIterator(TreeNode root) {
        // push to the leftmost leaf
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int res = curr.val;
        curr = curr.right;
        if (curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }

}

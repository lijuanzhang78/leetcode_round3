package Tree;

public class BinarySearchTreeIterator {
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    public BSTIterator(TreeNode root) {
        if (root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();   
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int res = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }

}

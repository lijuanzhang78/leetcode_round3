package Tree;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        LinkedList<TreeNode> stack = new LinkedList<>();
        
        // find the leftmost node in the tree, which is the smallest
        // and push the node to the stack, like the calling stack
        while(root != null) {
            stack.push(root);
            res.add(root.val);
            root = root.left;
        }
        
        // poping up
        while(stack.size() > 0) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                // find the right node and treat it like a new tree 
                curr = curr.right;
                while(curr != null) {
                    stack.push(curr);
                    res.add(curr.val);
                    curr = curr.left;
                }
            }
        }
        return res;
    }

}

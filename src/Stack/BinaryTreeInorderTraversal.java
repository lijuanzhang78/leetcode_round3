package Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        //res.add(root.val);
        TreeNode curr = root.left;
        while(stack.size() > 0) {
            while(curr != null) {
                stack.push(curr);
                //res.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right; // use curr.right as a new starting point
            if (curr != null) {
                stack.push(curr);
                //res.add(curr.val);
                curr = curr.left;
            }
        }
        return res;    
    }

}

package Stack;

// use test case [1,null,2,3] as an example
//
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        res.add(root.val);
        TreeNode curr = root.left;
        while(stack.size() > 0) {
            while(curr != null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop().right;
            if (curr != null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            }
        }
        return res;
    }

}

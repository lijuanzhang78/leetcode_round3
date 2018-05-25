package Google;

public class _230_KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int count = 0;
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(stack.size() > 0 || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = stack.pop();
                count++;
                if (count == k) {
                    return top.val;
                }
                curr = top.right;
            }    
        }
        return 0;
    }

}

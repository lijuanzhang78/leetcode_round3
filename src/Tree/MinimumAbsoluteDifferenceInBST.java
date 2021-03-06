package Tree;

public class MinimumAbsoluteDifferenceInBST {
	TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return min;
    }
    
    void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null) {
            min = Math.min(min, (root.val-prev.val));
        }
        prev = root;
        helper(root.right);
    }

}

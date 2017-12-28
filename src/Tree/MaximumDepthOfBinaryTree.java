package Tree;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left), right = maxDepth(root.right);
        return Math.max(left,right)+1;
    } 

}

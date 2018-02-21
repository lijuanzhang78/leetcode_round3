package Tree;

// 这道题很容易出错
// 如果左子树为null，需要取右子树的深度, 而不是取左子树的高度0
//
public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepthHelper(root);
    }
    
    int minDepthHelper(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return Math.min(minDepthHelper(root.left), minDepthHelper(root.right)) + 1;
    }

}

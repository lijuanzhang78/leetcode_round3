package Tree;

// 返回值为树的高度，如果返回值为负数，说明当前node为根节点的subtree不是平衡的，立刻return:
// if (left == -1) return -1;
// if (right == -1) return -1;
//
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }
    
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1; // 任何一个子树不平衡，立刻返回。
        int right = dfs(root.right);
        if (right == -1) return -1;
        if (Math.abs(left-right) > 1) return -1;
        return Math.max(left,right)+1;
    }

}

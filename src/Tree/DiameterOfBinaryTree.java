package Tree;

public class DiameterOfBinaryTree {
	int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }
        
    int helper(TreeNode root) {
        if (root == null) return 0;
        //int left = 0, right = 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int res = Math.max(left,right) + 1;
        max = Math.max(left+right,max);
        return res;
    }

}

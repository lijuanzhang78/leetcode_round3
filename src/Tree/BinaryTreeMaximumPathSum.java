package Tree;
//
// 特别注意子树path为负的情况,这是为什么 int left = Math.max(0,maxPath(root.left)); 要跟0比较大小的原因。
//
public class BinaryTreeMaximumPathSum {
	int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPath(root);
        return maxValue;
    }
    
    int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,maxPath(root.left)); // notice that the node value could be negative
        int right = Math.max(0,maxPath(root.right)); 
        maxValue = Math.max(maxValue,left+right+root.val);
        return Math.max(left,right) + root.val;
    }

}

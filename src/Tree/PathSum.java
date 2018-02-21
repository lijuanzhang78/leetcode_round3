package Tree;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }
    
    boolean helper(TreeNode root, int sum) {
        if (root.val == sum) {
            if (root.left == null && root.right == null) {
               return true;
            }
        }
        
        if (root.left != null) {
        	// put the return value of recursion inside if statement is very good practice.
            if (helper(root.left, sum - root.val)) return true;
        }
        if (root.right != null) {
            if (helper(root.right, sum - root.val)) return true;
        }
        return false;
    }

}

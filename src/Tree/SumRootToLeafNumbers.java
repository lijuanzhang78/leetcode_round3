package Tree;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return dfs(root,"",0);
    }
    
    int dfs(TreeNode root,String curr, int sum) {
        if (root.left == null && root.right == null) {
            return sum + Integer.valueOf(curr+root.val);
        }
        if (root.left != null) {
            sum = dfs(root.left,curr+root.val,sum);
        }
        if (root.right != null) {
            sum = dfs(root.right, curr+root.val,sum);
        }
        return sum;
    }

}

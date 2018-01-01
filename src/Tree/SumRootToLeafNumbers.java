package Tree;

// 第二版为改进版本
//
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
    
    //
    // 第二版
    //
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return helper(root,0);
    }
    
    int helper(TreeNode root, int curr) {
        if (root.left == null && root.right == null) {
            return curr*10 + root.val;
        }
        int left = 0, right = 0;
        if (root.left != null) left = helper(root.left, curr*10 + root.val);
        if (root.right != null) right = helper(root.right, curr*10 + root.val);
        return left + right;
    }

}

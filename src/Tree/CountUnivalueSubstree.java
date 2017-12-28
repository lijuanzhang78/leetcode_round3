package Tree;


// line 24 & 28 需要加上left > 0, right > 0, 保证整个subtree都是univalue
//
public class CountUnivalueSubstree {
	int sum = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return sum;
    }
    
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int res = 0;
        if (root.left != null && root.right != null && root.left.val == root.val && root.right.val == root.val && left > 0 && right > 0) {
            res = left + right + 1;
            sum++;
        } 
        if (root.left == null && root.right == null) {
            res = 1;
            sum++;
        }
        if (root.left == null && root.right != null && root.right.val == root.val && right > 0) {
            res = right + 1;
            sum++;
        }
        if (root.right == null && root.left != null && root.left.val == root.val && left > 0) {
            res = left + 1;
            sum++;
        }
        return res;
    }

}

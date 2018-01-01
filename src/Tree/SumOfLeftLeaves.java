package Tree;

public class SumOfLeftLeaves {
	int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root,-1);
        return res;
    }
    
    void sumOfLeftLeaves(TreeNode root, int parent) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (parent == 0) res += root.val;
        }
        sumOfLeftLeaves(root.left,0);
        sumOfLeftLeaves(root.right,1);
    }

}

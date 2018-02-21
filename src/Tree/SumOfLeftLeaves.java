package Tree;

// with global variable res
//
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
    

//    
// without global variable res
//
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root,-1);
    }
    
    public int sumOfLeftLeaves(TreeNode root, int parent) {
        if (root.left == null && root.right == null) {
            if (parent == 1) return root.val;
            return 0;
        }
        int res = 0;
        if (root.left != null) res += sumOfLeftLeaves(root.left,1);
        if (root.right != null) res += sumOfLeftLeaves(root.right,0);
        return res;
    }
}

package Tree;

//
// reverse inorder traversal and keep a running sum
//
public class ConvertBSTToGreaterTree {
	int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return root;
    }
    
    void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
        return;
    }

}

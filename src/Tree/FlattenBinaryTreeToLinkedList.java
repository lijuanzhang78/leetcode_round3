package Tree;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        if (root == null) return;
        helper(root);
    }
    
    TreeNode helper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        if (root.left != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) {
            return rightTail;
        } else {
            if (leftTail != null) {
                return leftTail;
            }
        }
        return null;
    }

}

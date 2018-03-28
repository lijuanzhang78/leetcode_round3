package Tree;

public class RecoverBinarySearchTree {
	TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        bstSwap(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    void bstSwap(TreeNode root) {
        if (root == null) return;
        bstSwap(root.left);
        if (prev != null && first == null && prev.val > root.val) {
            first = prev;
        } 
        if (first != null && prev.val > root.val) {
            second = root;
        }
        prev = root;
        bstSwap(root.right);
    }

}

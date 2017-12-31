package Tree;

public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null || root == null) return null;
        TreeNode succ = null;
        if (p.right != null) {
            TreeNode curr = p.right;
            while(curr.left != null) {
                curr = curr.left;
            }
            return curr;
        } else {
            while(root != null) {
                if (p.val < root.val) {
                    succ = root;
                    root = root.left;
                } else if (p.val > root.val) {
                    root = root.right;
                } else {
                    break;
                }
            }
            return succ;          
        }    
    }

}

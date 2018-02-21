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
	
	// this way is much more elegant!!!
	//
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while(root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
	
	// using the same idea, predecessor also can be found
	//
	public TreeNode inorderPredecessor (TreeNode root, TreeNode p) {
	    TreeNode pre = null;
	    while(root!=null) {
	        if(root.val < p.val) {
	        	pre = root;
	        	root = root.right;
	        }
	        else root = root.left;
	    }
	    return pre;
	}

}

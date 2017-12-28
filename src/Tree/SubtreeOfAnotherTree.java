package Tree;

public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s != null && t == null) return true;
        if (t != null && s == null) return false;
        return isSame(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    
    boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s != null && t == null || s == null && t != null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left,t.left) && isSame(s.right,t.right);   
    }

}

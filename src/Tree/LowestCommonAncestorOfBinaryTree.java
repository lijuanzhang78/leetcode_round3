package Tree;

// 重点题

public class LowestCommonAncestorOfBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null && q != null) return q;
        if (p != null && q == null) return p;
        return LCA(root,p,q);
    }
    
    TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right,p,q);
        if (left != null && right != null && left != right) return root;
        if (left != null && right == null) return left;
        if (left == null && right != null) return right;
        return null;
    }

}

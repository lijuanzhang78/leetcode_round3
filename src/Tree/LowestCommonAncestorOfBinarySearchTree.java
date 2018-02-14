package Tree;

public class LowestCommonAncestorOfBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        return root;   
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode p = new TreeNode(1);
		TreeNode q = new TreeNode(3);
		TreeNode res = new LowestCommonAncestorOfBinarySearchTree().lowestCommonAncestor(root, p, q);
	}
}

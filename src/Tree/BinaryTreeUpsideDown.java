package Tree;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = upsideDownBinaryTree(root.left);
        TreeNode right = upsideDownBinaryTree(root.right);
        root.left.left = root.right;
        root.left.right = root;
        //left.right = root;
        //left.left = root.right;
        root.left = null;
        root.right = null;
        return left;   
    }

}

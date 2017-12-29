package Tree;

// 很经典的一道题
// 思路：The leftmost node is the new root. The key is to go down along the leftmost path to find 
// the new root and reset all pointers when poping up

// TreeNode left = upsideDownBinaryTree(root.left);
// return left 注意这是找到the leftmost node 的方法，可以把leftmost node传到最上面一层
//
public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = upsideDownBinaryTree(root.left);
        //TreeNode right = upsideDownBinaryTree(root.right);
        root.left.left = root.right;
        root.left.right = root;
        //left.right = root;
        //left.left = root.right;
        root.left = null;
        root.right = null;
        return left;   
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
		node4.right = node7;
		
		TreeNode root = new BinaryTreeUpsideDown().upsideDownBinaryTree(node1);
		return;	
	}
}

package Tree;

// this is done recursively
//
public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right,key); // key in right subtree
        } else if (root.val > key) {
            root.left = deleteNode(root.left,key); // key in left subtree
        } else {
            // key found
            if (root.left == null) return root.right; // only right child
            if (root.right == null) return root.left; // only left child
            // has both left and right children
            // firstly need to find the min node of the right subtree
            TreeNode minNode = findMin(root.right);
            // copy the min value to the root(key)
            root.val = minNode.val;
            // need to delete the minNode in the right subtree
            root.right = deleteNode(root.right,minNode.val);
        }
        return root;
    }
    
    TreeNode findMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

}

package BinarySearch;

public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        if (left < k-1) return kthSmallest(root.right, k-left-1);
        if (left > k-1) return kthSmallest(root.left, k);
        return root.val;
    }
    
    int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}

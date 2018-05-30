package Google;

public class _298_BinaryTreeLongestConsecutiveSequence {
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        longestConsecutiveHelper(root);
        return max;
    }
    
    int longestConsecutiveHelper(TreeNode root) {
        if (root == null) return 0;
        int left = longestConsecutiveHelper(root.left);
        int right = longestConsecutiveHelper(root.right);
        if (root.left == null || root.left.val == root.val + 1) {
            left++;
        } else {
            left = 1;
        }
        if (root.right == null || root.right.val == root.val + 1) {
            right++;
        } else {
            right = 1;
        }
        max = Math.max(max,Math.max(left,right));
        return Math.max(left,right);
    }
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node5 = new TreeNode(1);
    	node1.right = node3;
    	node3.left = node2;
    	node3.right = node4;
    	node4.right = node5;
    	
    	int res = new _298_BinaryTreeLongestConsecutiveSequence().longestConsecutive(node1);
    	return;
    }
}

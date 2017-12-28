package Tree;

// need to use debugger to see the recursive process !!!
// 如果不加上 else {
//                left = 1
//               }
// 算例的结果是2， 因为在5节点的地方 return的值为0，那么最后即使right += 1，最后的值也只为2.
//
public class BinaryTreeLongestConsecutiveSequences {
	int maxLen = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        maxLenFrom(root);
        return maxLen;
    }
    
    int maxLenFrom(TreeNode root) {
        if (root == null) return 0;
        int left = maxLenFrom(root.left);
        int right = maxLenFrom(root.right);
        if (root.left != null && root.val == root.left.val - 1) {
            left += 1;
        } 
        //else {
        //    left = 1; // forgot his line so the answer is not right
        //}
        if (root.right != null && root.val == root.right.val - 1) {
            right += 1;
        } 
        //else {
        //    right = 1;
        //}
        int res = Math.max(left,right);
        maxLen = Math.max(maxLen,res);
        return res;
    }
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node5 = new TreeNode(5);
    	node1.right = node3; 
    	node3.left = node2;
    	node3.right = node4;
    	node4.right = node5;
    	int res = new BinaryTreeLongestConsecutiveSequences().longestConsecutive(node1);
    	return;
	
    }

}

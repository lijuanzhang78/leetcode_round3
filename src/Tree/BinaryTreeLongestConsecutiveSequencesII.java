package Tree;

public class BinaryTreeLongestConsecutiveSequencesII {
	int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        maxLenFrom(root);
        return max;
    }
    
    int[] maxLenFrom(TreeNode root) {
        int[] res = new int[2]; // first decrease, second increase
        if (root == null) return res;
        int[] left = maxLenFrom(root.left);
        int[] right = maxLenFrom(root.right);
        if (root.left != null && root.left.val + 1 == root.val) {
            left[0] += 1; 
        } else {
            left[0] = 1;
        }
        if (root.left != null && root.left.val - 1 == root.val) {
            left[1] += 1; 
        } else {
            left[1] = 1;
        }
        
        if (root.right != null && root.right.val + 1 == root.val) {
            right[0] += 1; 
        } else {
            right[0] = 1;
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            right[1] += 1; 
        } else {
            right[1] = 1;
        }
        
        res[0] = Math.max(left[0],right[0]);
        res[1] = Math.max(left[1],right[1]);
        max = Math.max(max,Math.max(left[0]+right[1]-1,left[1]+right[0]-1));
        return res;
    }
    
    public static void main(String[] args) {
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	
    	node3.left = node1;
    	node1.right = node2;
    	
    	int res = new BinaryTreeLongestConsecutiveSequencesII().longestConsecutive(node3);
    	return;
    }
}

package Tree;

public class LargestBSTSubtree {
	int max = Integer.MIN_VALUE;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        int[] extreme = new int[2]; // keep track of min/max;
        largestBST(root,extreme);
        return max;
    }
    
    int largestBST(TreeNode root, int[] extreme) {
        if (root.left == null && root.right == null) {
            extreme[0] = root.val;
            extreme[1] = root.val;
            max = Math.max(max, 1);
            return 1;
        }
        
        int size = 0, left = 0, right = 0;
        int[] le = new int[2];
        if (root.left != null) {
            left = largestBST(root.left,le);
        }
        int[] re = new int[2];
        if (root.right != null) {
            right = largestBST(root.right,re);
        }
        
        if (left < 0 || right < 0) return -1; // any subtree is not BST
        
        if (root.left != null && root.right != null && root.val > le[1] && root.val < re[0]) {
            size = left + right + 1;
            max = Math.max(size, max);
            extreme[0] = le[0];
            extreme[1] = re[1];
            return size;
        } else if (root.left != null && root.right == null && root.val > le[1]) {
            size = left + 1;
            max = Math.max(size, max);
            extreme[0] = le[0];
            extreme[1] = root.val;
            return size;
        } else if (root.right != null && root.left == null && root.val < re[0]) {
            size = right + 1;
            max = Math.max(size, max);
            extreme[0] = root.val;
            extreme[1] = re[1];
            return size;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	TreeNode node10 = new TreeNode(10);
    	TreeNode node5 = new TreeNode(5);
    	TreeNode node15 = new TreeNode(15);
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node8 = new TreeNode(8);
    	TreeNode node7 = new TreeNode(7);
    	
    	node10.left = node5;
    	node10.right = node15;
    	node5.left = node1;
    	node5.right = node8;
    	node15.right =node7;
    	
    	int res = new LargestBSTSubtree().largestBSTSubtree(node10);
    	return;
    }

}

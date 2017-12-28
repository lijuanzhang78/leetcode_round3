package Tree;

public class LongestUnivaluePath {
	 int max = 0; // longest univalue path result
	    public int longestUnivaluePath(TreeNode root) {
	        dfs(root);
	        return max;
	    }
	    
	    int dfs(TreeNode root) {
	        if (root == null) return 0;
	        int left = 0, right = 0;
	        if (root.left == null && root.right == null) return 0;
	        if (root.left == null) {
	            left = 0;
	        } else {
	            left = dfs(root.left); 
	        }
	        if (root.right == null) {
	            right = 0;
	        }
	        else {
	            right = dfs(root.right);
	        }
	        
	        if (root.left != null && root.left.val == root.val) {
	            left += 1; 
	        } else {
	            left = 0;
	        }
	        if (root.right != null && root.right.val == root.val) {
	            right += 1;
	        } else {
	            right = 0;
	        }
	        max = Math.max(left+right,max);
	        return Math.max(left,right);
	    }

}

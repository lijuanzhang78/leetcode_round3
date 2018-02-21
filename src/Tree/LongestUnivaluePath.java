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
	    
	    // second simpler way
	    //
	    int max = Integer.MIN_VALUE;
	    public int longestUnivaluePath(TreeNode root) {
	        if (root == null) return 0;
	        longestPath(root);
	        return max-1;
	    }
	    
	    int longestPath(TreeNode root) {
	        if (root == null) return 0;
	        int left = longestPath(root.left);
	        int right = longestPath(root.right);
	        int res = 1; // at least 1
	        if (root.left != null && root.left.val == root.val) {
	            res = Math.max(res, left+1);
	        }
	        if (root.right != null &&  root.right.val == root.val) {
	            res = Math.max(res, right+1);
	        }
	        max = Math.max(res,max);
	        if (root.left != null && root.right != null && root.left.val == root.val && root.right.val == root.val) {
	            max = Math.max(max,left+right+1);
	        }
	        return res;
	    }

}

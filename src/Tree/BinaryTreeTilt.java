package Tree;

public class BinaryTreeTilt {
	public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[2];
        res = helper(root);
        return res[0];    
    }
    
    int[] helper(TreeNode root) {
        int[] res = new int[2];
        int[] left = new int[2];
        int[] right = new int[2];
        if (root.left != null) left = helper(root.left);
        if (root.right != null) right = helper(root.right);
        res[0] = Math.abs(left[1]-right[1]) + left[0] + right[0];
        res[1] = root.val + left[1] + right[1];
        return res;
    }

}

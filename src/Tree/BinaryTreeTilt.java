package Tree;

// 第二版是改进版

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
    
    // 第二版
    //
    public int findTilt(TreeNode root) {
        int[] res = new int[2];
        res = helper(root);
        return res[0];
    }
    
    int[] helper(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            res[0] = 0; res[1] = 0;
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int sum = left[1] + right[1] + root.val;
        int tilt = Math.abs(left[1] - right[1]);
        res[1] = sum;
        res[0] = left[0] + right[0] + tilt;
        return res;
    }
    
    

}

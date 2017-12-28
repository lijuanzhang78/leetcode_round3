package Tree;

// 与path sum III类似
//
public class HouseRobIII {
	public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robFrom(root), rob(root.left) + rob(root.right)); 
    }
    
    int robFrom(TreeNode root) {
        if (root == null) return 0;
        int res = root.val;
        if (root.left != null) res += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) res += rob(root.right.left) + rob(root.right.right);
        return res;
    }

}

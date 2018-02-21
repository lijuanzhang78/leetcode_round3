package Tree;

// it can be done either recursively or iteratively
//
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        int candidate = root.val;
        while(root != null) {
            if ((double)root.val == target) return root.val;
            if (Math.abs((double)root.val-target) <= Math.abs((double)candidate - target)) {
                candidate = root.val;
            }
            if (target > (double)root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return candidate;   
    }
	
	public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        int candidate = root.val;
        return closestValue(root,target,candidate);
    }
    
    int closestValue(TreeNode root, double target, int candidate) {
        if (root == null) return candidate;
        if ((double)root.val == target) return root.val;
        if (Math.abs(root.val - target) < Math.abs(candidate - target)) candidate = root.val;
        if (root.val < target) {
            return closestValue(root.right,target,candidate);
        } else {
            return closestValue(root.left,target,candidate);
        }
    }

}

package BinarySearch;

public class ClosestBinarySearchTreeValue_2 {
	public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        // root.val is the first candidate
        return closestValue(root,target,root.val); 
    }
    
    int closestValue(TreeNode root, double target, int candidate) {
        if (root == null) return candidate;
        if (root.val == target) return root.val;
        if (Math.abs(root.val-target) < Math.abs(candidate-target)) {
            candidate = root.val;
        }
        if (target <= root.val) return closestValue(root.left,target,candidate);
        return closestValue(root.right,target,candidate);
    }

}

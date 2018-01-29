package BinarySearch;

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
	       return closestValue(root, target, root.val);
	    }
	    
	    int closestValue(TreeNode root, double target, int currVal) {
	        if (root == null) return currVal;
	        if (Math.abs(target-root.val) < Math.abs(target-currVal)) {
	            currVal = root.val;
	        }
	        if (target > (double)root.val) return closestValue(root.right,target,currVal);
	        return closestValue(root.left,target,currVal);
	    }

}

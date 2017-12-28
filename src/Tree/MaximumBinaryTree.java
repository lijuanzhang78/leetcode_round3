package Tree;

public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = helper(nums,0,nums.length-1);
        return root;
    }
    
    TreeNode helper(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int[] res = getMax(nums,begin,end);
        TreeNode root = new TreeNode(res[0]);
        root.left = helper(nums,begin,res[1]-1);
        root.right = helper(nums,res[1]+1,end);
        return root;
    }
    
    int[] getMax(int[] nums, int begin, int end) {
        int[] res = new int[2];
        res[0] = Integer.MIN_VALUE;
        for(int i = begin; i <= end; i++) {
            if (nums[i] > res[0]) {
                res[0] = nums[i];
                res[1] = i;
            }
        }
        return res;
    }

}

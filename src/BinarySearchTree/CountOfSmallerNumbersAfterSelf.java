package BinarySearchTree;


// Arrays.asList(int[]) 当里面是primitive数组是不适用的，只能用Integer[]
// 这道题可以 BST， BIT， merge sort
//
public class CountOfSmallerNumbersAfterSelf {
	class TreeNode {
        TreeNode left, right;
        int val, count, dup = 1;
        public TreeNode(int val, int count) {
            this.val = val;
            this.count = count; // number of left tree nodes
        }
    }
        
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        // build the BST
        TreeNode root = null;
        for(int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }
    
    // insert node to the BST
    TreeNode insert(int val, TreeNode node, Integer[] res, int i, int preSum) {
        if (node == null) {
            node = new TreeNode(val, 0); // when built, the numebr of left tree node is 0.
            res[i] = preSum; // number of nodes that are smaller than val
        } else if (node.val == val) {
            node.dup++;
            res[i] = preSum + node.count; 
        } else if (node.val > val) {
            node.count++;
            node.left = insert(val,node.left,res,i,preSum);
        } else {
            node.right = insert(val,node.right,res,i,preSum+node.dup+node.count);    
        }
        return node;
    }

}

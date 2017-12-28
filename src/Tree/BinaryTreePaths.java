package Tree;

// backtrack
// 对于leaf node，不用再加箭头
//
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        helper(res,root,"");
        return res;
    }
    
    void helper(List<String> res, TreeNode root,String curr) {
        if (root.left == null && root.right == null) {
            res.add(curr+root.val);
            return;
        }
        if (root.left != null) helper(res,root.left,curr + root.val + "->");
        if (root.right != null) helper(res,root.right,curr + root.val + "->");
    }

}

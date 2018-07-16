package Google;

public class _257_BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        helper(root,res,"");
        return res;
    }
    
    void helper(TreeNode root, List<String> res, String temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            temp = temp + root.val;
            res.add(temp);
            return;
        } else {
            helper(root.left,res,temp+root.val+"->");
            helper(root.right,res,temp+root.val+"->");    
        }
    }

}

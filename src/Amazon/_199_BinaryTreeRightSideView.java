package Amazon;

public class _199_BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root,res, 0);
        return res;
    }
    
    void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        }
        helper(root.right,res,depth+1);
        helper(root.left,res,depth+1);
    }

}

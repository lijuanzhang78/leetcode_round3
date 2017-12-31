package Tree;

// DFS的做法，使用depth

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root,res,0);
        return res;
    }
    
    void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        helper(root.left,res,depth+1);
        helper(root.right,res,depth+1);
    }

}

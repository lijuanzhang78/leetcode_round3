package Tree;

public class FindLeavesOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root,res);
        return res;
    }
    
    int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) return 0;
        int left = dfs(root.left,res);
        int right = dfs(root.right,res);
        int depth = Math.max(left,right) + 1;
        if (res.size() <= (depth-1)) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth-1).add(root.val);
        return depth;
    }

}

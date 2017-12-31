package Tree;

public class BinaryTreeZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root,res,0);
        return res;
    }
    
    void dfs(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;
        if (res.size() == depth) res.add(new ArrayList<Integer>());
        if (depth % 2 == 0) {
            res.get(depth).add(root.val); 
        } else {
            res.get(depth).add(0,root.val);
        }
        dfs(root.left,res,depth+1);
        dfs(root.right,res,depth+1);
        return;
    }

}

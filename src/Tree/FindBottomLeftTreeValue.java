package Tree;

// dfs & bfs
// 错误地方：不应该加return（参见comment out语句）
//
public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[2];
        dfs(root,res,1);
        return res[0];
    }
    
    void dfs(TreeNode root, int[] res, int depth) {
        if (root == null) return;
        if (res[1] < depth) {
            res[1] = depth;
            res[0] = root.val;
            // return;
         }
         dfs(root.left, res, depth+1);
         dfs(root.right,res, depth+1);
         return;   
    }    

}

package Tree;

// dfs & bfs
// 错误地方：不应该加return（参见comment out语句）
// 改进了一下
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
    
    public int findBottomLeftValue_2(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[2];
        res[0] = -1; //depth
        dfs_2(root,res,0);
        return res[1];
    }
    
    void dfs_2(TreeNode root, int[] res, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (res[0] < depth) {
                res[0] = depth;
                res[1] = root.val;
            }
            return;
        }
        dfs_2(root.left,res,depth+1);
        dfs_2(root.right,res,depth+1);
    }

}

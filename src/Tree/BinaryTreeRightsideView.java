package Tree;

// 这道题可以bfs，也可以dfs，bfs很好想
// 注意看看dfs的解法，每次先traverse右节点，如果没有右节点就traverse左节点
//
public class BinaryTreeRightsideView {
	public List<Integer> rightSideView_bfs(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) res.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return res;   
    }
	
	public List<Integer> rightSideView_dfs(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
    
        List<Integer> res = new ArrayList<Integer>();
        dfs(root,res,0);
        return res;   
    }
    
    void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        if (res.size() == depth) res.add(root.val);
        if (root.right != null) dfs(root.right,res,depth+1);
        if (root.left != null) dfs(root.left,res,depth+1);
    }

}

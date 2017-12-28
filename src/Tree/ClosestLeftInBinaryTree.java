package Tree;

// DFS + BFS
// DFS: traverse整个树，找到target，并返回target的节点，注意找到以后不能马上返回，因为需要遍历整个树，得到一个w
// 完整的adjacency
// BFS: 把target当成起始点，找离target最近的叶子节点
//
public class ClosestLeftInBinaryTree {
	public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return 0;
        Map<TreeNode,TreeNode> map = new HashMap<>();
        TreeNode target = findTarget(root, k, map);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) {
                    return curr.val;
                }
                if (curr.left != null && !set.contains(curr.left)) {
                    q.offer(curr.left);
                    set.add(curr.left);
                }
                if (curr.right != null && !set.contains(curr.right)) {
                    q.offer(curr.right);
                    set.add(curr.right);
                }
                if (map.containsKey(curr) && !set.contains(map.get(curr))) {
                    q.offer(map.get(curr));
                    set.add(map.get(curr));
                }
            }
        }
        return 0;   
    }
    
    TreeNode findTarget(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root == null) return null;
        TreeNode res = null;
        if (root.val == k) {
            res = root;
            // no return here, as we want to continue;
        }
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        
        TreeNode left = findTarget(root.left,k,map);
        TreeNode right = findTarget(root.right,k,map);
        if (left != null) return left;
        if (right != null) return right;
        return res;
    }

}

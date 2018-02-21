package Tree;

public class CloesestleafInABinaryTree {
	public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return 0;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        TreeNode target = findTarget(root,k,map);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);
        
        int res = 0;
        while(q.size() > 0) {
            TreeNode curr = q.poll();
            if (curr.left == null && curr.right == null) {
                res = curr.val;
                break;
            }
            if (map.containsKey(curr)) {
                if (!visited.contains(map.get(curr))) {
                    q.offer(map.get(curr));
                    visited.add(map.get(curr));
                }
            }
            if (curr.left != null && !visited.contains(curr.left)) {
                q.offer(curr.left); visited.add(curr.left);
            }
            if (curr.right != null && !visited.contains(curr.right)) {
                q.offer(curr.right); visited.add(curr.right);
            } 
        }
        return res;
    }
    
    TreeNode findTarget(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root == null) return null;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        TreeNode res = null;
        if (root.val == k) res = root;
        TreeNode left = findTarget(root.left,k,map);
        TreeNode right = findTarget(root.right,k,map);
        if (left != null) res = left;
        if (right != null) res = right;
        return res;
    }

}

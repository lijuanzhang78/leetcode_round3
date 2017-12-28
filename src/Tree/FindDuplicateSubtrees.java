package Tree;

public class FindDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,List<TreeNode>> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (root == null) return res;
        postOrder(root,map);
        for(List<TreeNode> list : map.values()) {
            if (list.size() > 1) {
                res.add(list.get(0));
            }
        }
        return res;
    }
    
    String postOrder(TreeNode root, Map<String,List<TreeNode>> map) {
        if (root == null) return " ";
        String left = postOrder(root.left,map);
        String right = postOrder(root.right,map);
        String roots = root.val + "#" + left + "#" + right;
        if (!map.containsKey(roots)) {
            map.put(roots, new ArrayList<TreeNode>());
        } 
        map.get(roots).add(root);
        return roots;
    }

}
